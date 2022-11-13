package com.example.knm

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.icu.text.CaseMap
import android.nfc.Tag
import android.os.Bundle
import android.os.Debug
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.knm.databinding.ActivityMainBinding
import com.google.firebase.firestore.DocumentChange
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.handleCoroutineException
import java.util.*
import kotlin.collections.ArrayList


class News_Fragment : Fragment(R.layout.fragment_my_stock_) {
    private lateinit var NewsAdapter: NewsViewAdapter
    private lateinit var NewsRecyclerView: RecyclerView
    private lateinit var NewsList: ArrayList<NewsData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NewsList = arrayListOf<NewsData>()
        AutoDowolandData()

        NewsRecyclerView = view.findViewById(R.id.NewsRecyclerView)
        NewsRecyclerView.layoutManager = GridLayoutManager(context,2)
        NewsRecyclerView.setHasFixedSize(true)
        NewsAdapter = NewsViewAdapter(NewsList)
        NewsRecyclerView.adapter = NewsAdapter
    }

    fun AutoDowolandData(){

        val db = Firebase.firestore
        db.collection("News EU").addSnapshotListener { querySnapshot, e ->
            Log.w(TAG, " CIPY llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll")
            e?.let {
                Log.w(TAG, "Listen failed.", e)
                return@addSnapshotListener
            }
            querySnapshot?.let {
                Log.w(TAG, " DUPY llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll")

                for (doc in it) {
                    NewsList.add(doc.toObject<NewsData>())
                    Log.w(TAG, "${NewsList.count()} KUTASY llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll")
                    Log.w(TAG, "${NewsList[0].title} KUTASY llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll")

                }
                NewsAdapter = NewsViewAdapter(NewsList)
                Log.w(TAG, "${NewsList.count()} KUTASY1 llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll")
                Log.w(TAG, "${NewsAdapter.itemCount} KUTASY2 llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll")
            }
            Log.w(TAG, "${ NewsRecyclerView.getAdapter()?.getItemCount()} DUPY2 llllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll")
        }


    }
}



