package com.example.knm
import com.google.firebase.messaging.ktx.remoteMessage
import android.content.ContentValues.TAG
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging

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
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.getResult()

            // Log and toast
            val msg = getString(androidx.browser.R.string.copy_toast_msg, token)
            Log.d(TAG, msg)
            Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()

        })


        RegisterBtn.setOnClickListener{
            if(TermsCheckBox.isChecked){

                auth.createUserWithEmailAndPassword(EmailEditText.text.toString(),PasswordEditText.text.toString()).addOnCompleteListener{
                        task -> if (task.isSuccessful){
                            val Data = hashMapOf("Email" to EmailEditText.text.toString(),"password" to PasswordEditText.text.toString(),"login" to LoginEditText.text.toString())
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
