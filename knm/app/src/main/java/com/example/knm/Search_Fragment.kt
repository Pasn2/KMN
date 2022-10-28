package com.example.knm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Search_Fragment : Fragment(R.layout.fragment_search_) {
    private lateinit var SearchAdapter:SearchCategoryViewAdapter
    private lateinit var SearchRecyclerView: RecyclerView
    private lateinit var SearchList:ArrayList<SearchCategoryData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DowlonadData()
        val SearchLayoutManager = GridLayoutManager(context,2)
        SearchRecyclerView = view.findViewById(R.id.SearchRecyclerView)
        SearchRecyclerView.layoutManager = SearchLayoutManager
        SearchRecyclerView.setHasFixedSize(true)
        SearchAdapter = SearchCategoryViewAdapter(SearchList)
        SearchRecyclerView.adapter = SearchAdapter

    }
    fun DowlonadData(){

        SearchList = arrayListOf<SearchCategoryData>()
        val SearchCategory = SearchCategoryData("BTC",32)
        SearchList.add(SearchCategory)
        SearchList.add(SearchCategory)
        SearchList.add(SearchCategory)
        SearchList.add(SearchCategory)
        SearchList.add(SearchCategory)
        SearchList.add(SearchCategory)
        SearchList.add(SearchCategory)
        SearchList.add(SearchCategory)
        SearchList.add(SearchCategory)
        SearchList.add(SearchCategory)
        SearchList.add(SearchCategory)
    }

}