package com.example.knm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.knm.databinding.ActivityMainBinding


class MyStock_Fragment : Fragment(R.layout.fragment_my_stock_) {
    private lateinit var NewsAdapter:NewsViewAdapter
    private lateinit var NewsRecyclerView: RecyclerView
    private lateinit var NewsList:ArrayList<NewsData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataDowloand()
        val NewsLayoutManager = GridLayoutManager(context,1)
        NewsRecyclerView = view.findViewById(R.id.NewsRecyclerView)
        NewsRecyclerView.layoutManager = NewsLayoutManager
        NewsRecyclerView.setHasFixedSize(true)
        NewsAdapter = NewsViewAdapter(NewsList)
        NewsRecyclerView.adapter = NewsAdapter

    }
    fun DataDowloand(){
        val News1 = NewsData("KUTAS","JEBACPIS","DWDADWADAWDAW")
        NewsList = arrayListOf<NewsData>()
        NewsList.add(News1)
        NewsList.add(News1)
        NewsList.add(News1)
        NewsList.add(News1)
        NewsList.add(News1)
        NewsList.add(News1)
        NewsList.add(News1)
        NewsList.add(News1)
        NewsList.add(News1)
        NewsList.add(News1)
        NewsList.add(News1)
        NewsList.add(News1)
        NewsList.add(News1)


        //Dowloand Data From Server to implement
    }

}