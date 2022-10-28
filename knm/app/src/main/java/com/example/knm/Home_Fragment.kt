package com.example.knm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.knm.databinding.FragmentHomeBinding


class Home_Fragment : Fragment(R.layout.fragment_home_) {


    private lateinit var Observedadapter:ObervedCardViewAdapter
    private lateinit var ObservedrecyclerView: RecyclerView
    private lateinit var ObservedStockList:ArrayList<StockData>
    private lateinit var LastSeenAdapter:LastSeenCardViewAdapter
    private lateinit var LastSeenRecytclerView:RecyclerView
    private lateinit var LastSeenList:ArrayList<StockData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataDowloand()

        val ObservedlayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        ObservedrecyclerView = view.findViewById(R.id.LastSeenRecyclerView)
        ObservedrecyclerView.layoutManager = ObservedlayoutManager
        ObservedrecyclerView.setHasFixedSize(true)
        Observedadapter = ObervedCardViewAdapter(ObservedStockList)
        ObservedrecyclerView.adapter = Observedadapter
        val LastSeenlayoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        LastSeenRecytclerView = view.findViewById(R.id.ObservedRecyclerView)
        LastSeenRecytclerView.layoutManager = LastSeenlayoutManager
        LastSeenRecytclerView.setHasFixedSize(true)
        LastSeenAdapter = LastSeenCardViewAdapter(LastSeenList)
        LastSeenRecytclerView.adapter = LastSeenAdapter

    }
    fun DataDowloand(){
        ObservedStockList = arrayListOf<StockData>()
        LastSeenList = arrayListOf<StockData>()
        val KGHM = StockData("KGHM",300,"20dwadaw0",22,"IRON BRRRRRR",3)
        val TSLA = StockData("TSLA",30,"Tesla CO.",300,"Car brrrr",3)
        LastSeenList.add(TSLA)
        LastSeenList.add(KGHM)
        LastSeenList.add(KGHM)
        LastSeenList.add(TSLA)
        LastSeenList.add(KGHM)
        LastSeenList.add(TSLA)
        ObservedStockList.add(TSLA)
        ObservedStockList.add(KGHM)
        ObservedStockList.add(TSLA)
        ObservedStockList.add(KGHM)
        ObservedStockList.add(TSLA)
        ObservedStockList.add(KGHM)
        ObservedStockList.add(TSLA)
        ObservedStockList.add(KGHM)
        ObservedStockList.add(TSLA)

        //Dowloand Data From Server to implement
    }

}