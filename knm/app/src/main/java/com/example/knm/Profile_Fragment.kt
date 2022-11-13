package com.example.knm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.knm.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.nio.channels.Channel


class Profile_Fragment : Fragment(R.layout.fragment_profile_) {
    private lateinit var MyStockAdapter:MyStocksCardViewAdapter
    private lateinit var MyStockRecyclerView: RecyclerView
    private lateinit var MyStockList:ArrayList<StockData>
    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIF_ID = 101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        createNotificationChannel()

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val MyStockLayoutManager = GridLayoutManager(context,2)
        val LogOutBtn:Button = view.findViewById(R.id.LogOutBtnMyProfile)
        val SettingsBtn:Button = view.findViewById(R.id.ProfileSettingsBtn)
        val TestBtn:Button = view.findViewById(R.id.TestBtn)
        DataDowloand()
        val notification = NotificationCompat.Builder(requireContext(),CHANNEL_ID)
            .setContentTitle("FINANCE")
            .setContentText("NUDES SENDED")
            .setSmallIcon(R.drawable.ic_baseline_person_24)
            .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.mipmap.ic_launcher))
            .build()
        val notifmanager = NotificationManagerCompat.from(requireContext())
        TestBtn.setOnClickListener{
            notifmanager.notify(NOTIF_ID,notification)
        }





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
    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "getString(R.string.channel_name)"
            val descriptionText = "getString(R.string.channel_description)"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager = activity?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

}