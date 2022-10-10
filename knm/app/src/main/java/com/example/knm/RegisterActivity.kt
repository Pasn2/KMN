package com.example.knm

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        var db = Firebase.firestore
        val RegisterBtn:Button = findViewById(R.id.RegisterBtn)
        val EmailEditText:EditText = findViewById(R.id.RegisterEmailEditText)
        val LoginEditText:EditText = findViewById(R.id.RegisterLoginEditText)
        val PasswordEditText:EditText = findViewById(R.id.RegisterPasswordEditText)
        val TermsCheckBox:CheckBox = findViewById(R.id.RegisterTermsCheckBox)
        auth = Firebase.auth



        RegisterBtn.setOnClickListener{
            if(TermsCheckBox.isChecked){
                auth.createUserWithEmailAndPassword(EmailEditText.text.toString(),PasswordEditText.text.toString()).addOnCompleteListener{
                        task -> if (task.isSuccessful){
                            val Data = hashMapOf(EmailEditText.text.toString() to String,PasswordEditText.text.toString() to String)
                    db.collection("Users").document(EmailEditText.text.toString()).set(Data)
                        .addOnCompleteListener{
                            println("Koxx")
                        }
                        .addOnFailureListener {
                            println("NieKoxx")
                        }
                    Toast.makeText(applicationContext,"Register correctly",Toast.LENGTH_LONG).show()
                    val intent = Intent(this,LoginActivity::class.java).apply {
                    }
                    startActivity(intent)
                }else {
                    Toast.makeText(applicationContext,"Register incorrectly try again",Toast.LENGTH_LONG).show()

                    }
                }

            }else{
                Toast.makeText(applicationContext,"Please Accept Terms",Toast.LENGTH_LONG)
            }


        }


        }

    }
