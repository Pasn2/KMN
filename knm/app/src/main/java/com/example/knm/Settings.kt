package com.example.knm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase
import java.util.*

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val SettingsChangeemailEditText:EditText = findViewById(R.id.SettingsEmailEditText)
        val SettingsChangeemailBtn:Button = findViewById(R.id.SettingsSaveChageEmailBtn)
        val ChangePasswordEditTxt:EditText = findViewById(R.id.SettingsPasswordEditText)
        val ChangePasswordBtn:Button = findViewById(R.id.SettingsSaveChagePasswordBtn)
        val ThemeSwitch:Switch = findViewById(R.id.SettingsThemeSwitch)
        val curuser = Firebase.auth.currentUser


        ThemeSwitch.setOnCheckedChangeListener{ _ , isChecked ->
            val ChangeTheme = if (isChecked) AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES) else  AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        }
        SettingsChangeemailBtn.setOnClickListener{
            if(!SettingsChangeemailEditText.text.isNullOrEmpty()){
                curuser!!.updatePassword(SettingsChangeemailEditText.text.toString()).addOnCompleteListener{task ->
                    if (task.isSuccessful){
                        Toast.makeText(applicationContext,"Email Changed.",Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(applicationContext,"Error.",Toast.LENGTH_SHORT).show()
                    }

                }
            }

        }
        ChangePasswordBtn.setOnClickListener{
            if(!ChangePasswordEditTxt.text.isNullOrEmpty()) {
                curuser!!.updatePassword(ChangePasswordEditTxt.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(applicationContext, "Password Changed.", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(applicationContext, "Error.", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}