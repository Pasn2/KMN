package com.example.knm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.knm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ChangeFragment(Home_Fragment())
        binding.bottomNavigationView.setOnItemSelectedListener{


            when(it.itemId){
                R.id.HomeBtn ->{
                    ChangeFragment(Home_Fragment())
                }
                R.id.SearchBtn ->{
                    ChangeFragment(Search_Fragment())
                }
                R.id.MyStocks ->{
                    ChangeFragment(MyStock_Fragment())
                }
                R.id.ProfileBtn ->{
                    ChangeFragment(Profile_Fragment())
                }
            }
            return@setOnItemSelectedListener true
        }
    }
    fun ChangeFragment(fragment: Fragment){

        var fragmentManager:FragmentManager = supportFragmentManager
        var fragmenttransaction:FragmentTransaction = fragmentManager.beginTransaction()
        fragmenttransaction.replace(R.id.MainFrameLayout,fragment)
        fragmenttransaction.commit()
    }
}