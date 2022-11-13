package com.example.knm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var db = Firebase.firestore
        val LoginBtn = findViewById<Button>(R.id.LogInBtn)
        val SingUp = findViewById<Button>(R.id.SignUpBtn)
        val ForgotBtn = findViewById<Button>(R.id.ForgotBtn)
        val PasswordEditText = findViewById<EditText>(R.id.PasswordEditText)
        val EmailEditText = findViewById<EditText>(R.id.EmailEditText)
        auth = Firebase.auth
        SingUp.setOnClickListener{
            val SingUpIntent = Intent(this,RegisterActivity::class.java).apply {}

            startActivity(SingUpIntent)
        }
        ForgotBtn.setOnClickListener{
            val ForgotPassIntent = Intent(this,ForgotPassActivity::class.java).apply {}

            startActivity(ForgotPassIntent)
        }
        LoginBtn.setOnClickListener{
            if(!EmailEditText.text.isNullOrEmpty() || PasswordEditText.text.isNullOrEmpty()){
                auth.signInWithEmailAndPassword(EmailEditText.text.toString(),PasswordEditText.text.toString()).addOnCompleteListener{task ->
                    if (task.isSuccessful) {
                        Toast.makeText(applicationContext,"Loggin Sucesfull",Toast.LENGTH_SHORT).show()
                        val intent = Intent(this,MainActivity::class.java).apply {}
                        startActivity(intent)
                        PasswordEditText.text = null
                        EmailEditText.text = null

                    }
                    else{
                        Toast.makeText(applicationContext,"Error",Toast.LENGTH_SHORT).show()
                    }


                }.addOnFailureListener { exeption ->
                    Toast.makeText(applicationContext,"Error $exeption",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}