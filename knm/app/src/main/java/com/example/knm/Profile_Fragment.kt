package com.example.knm

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.knm.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class Profile_Fragment : Fragment(R.layout.fragment_profile_) {
    private lateinit var MyStockAdapter:MyStocksCardViewAdapter
    private lateinit var MyStockRecyclerView: RecyclerView
    private lateinit var MyStockList:ArrayList<StockData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataDowloand()
        val MyStockLayoutManager = GridLayoutManager(context,2)
        val LogOutBtn:Button = view.findViewById(R.id.LogOutBtnMyProfile)
        val SettingsBtn:Button = view.findViewById(R.id.ProfileSettingsBtn)
        LogOutBtn.setOnClickListener{
            Toast.makeText(context,"Sucessful Log out.",Toast.LENGTH_SHORT)
            Firebase.auth.signOut()
            val movetoMainIntent = Intent(context,LoginActivity::class.java)
            startActivity(movetoMainIntent)
        }
        SettingsBtn.setOnClickListener{
            val settingsintent = Intent(context,Settings::class.java)
            startActivity(settingsintent)
        }
        MyStockRecyclerView = view.findViewById(R.id.MyProfileStockRecycler)
        MyStockRecyclerView.layoutManager = MyStockLayoutManager
        MyStockRecyclerView.setHasFixedSize(true)
        MyStockAdapter = MyStocksCardViewAdapter(MyStockList)
        MyStockRecyclerView.adapter = MyStockAdapter

    }
    fun DataDowloand(){
        val Stock = StockData("KUTAS",8000,"DWDADWADAWDAW",300,"d",2)
        MyStockList = arrayListOf<StockData>()
        MyStockList.add(Stock)
        MyStockList.add(Stock)
        MyStockList.add(Stock)



    }
}