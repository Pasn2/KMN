package com.example.knm

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class SearchCategoryViewAdapter(private val SearchCategoryDataList: ArrayList<SearchCategoryData>): RecyclerView.Adapter<SearchCategoryViewAdapter.MyViewHolder>() {


    lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchCategoryViewAdapter.MyViewHolder {

        context = parent.context
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.search_card,parent,false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SearchCategoryViewAdapter.MyViewHolder, position: Int) {

        val currentItem = SearchCategoryDataList[position]
        holder.CategoryName.text = currentItem.categoryname
        holder.CategoryAmount.text = "${currentItem.amount} items"
        val cardview = holder.itemView.findViewById<CardView>(R.id.SearchCardView)
        cardview.setOnClickListener{
            val itent = Intent(context,stock_char_view::class.java)
            context.startActivity(itent)

        }


    }

    override fun getItemCount(): Int {
        return SearchCategoryDataList.size
    }
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val CardView: CardView = itemView.findViewById(R.id.SearchCardView)
        val CategoryName: TextView = itemView.findViewById(R.id.SearchCategoryName)
        val CategoryAmount: TextView =itemView.findViewById(R.id.SearchAmotunText)


    }
}
