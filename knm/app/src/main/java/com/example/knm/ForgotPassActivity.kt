package com.example.knm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ForgotPassActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)
        val EmailEditText:EditText = findViewById(R.id.EmailTextEdit)
        val InfoTextView:TextView = findViewById(R.id.EmailSendTextView)
        val SendEmailBtn:Button = findViewById(R.id.SendEmailBtn)

        SendEmailBtn.setOnClickListener{
            if (!EmailEditText.text.isNullOrEmpty())
            {
                auth = Firebase.auth
                auth.sendPasswordResetEmail(EmailEditText.text.toString()).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        InfoTextView.setText("Email was sent")
                    }

                }

            }else{
                Toast.makeText(applicationContext,"Please enter email",Toast.LENGTH_SHORT).show()
            }
        }


    }
}