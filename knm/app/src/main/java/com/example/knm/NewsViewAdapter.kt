package com.example.knm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NewsViewAdapter(private val NewsList: ArrayList<NewsData>): RecyclerView.Adapter<NewsViewAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_card,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = NewsList[position]
        holder.NewsTitle.text = currentItem.title
        holder.NewsShortDesc.text = currentItem.Descryption

    }

    override fun getItemCount(): Int {
        return NewsList.size
    }
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val NewsTitle: TextView = itemView.findViewById(R.id.NewsTitleText)
        val NewsShortDesc: TextView =itemView.findViewById(R.id.NewsShortDescryptionText)
    }
}