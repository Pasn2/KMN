package com.example.knm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyStocksCardViewAdapter(private val stocklist: ArrayList<StockData>): RecyclerView.Adapter<MyStocksCardViewAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.stock_card_without_btns,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = stocklist[position]
        holder.ScStockName.text = currentItem.ShortcutName
        holder.Descryition.text = currentItem.Descryption
    }

    override fun getItemCount(): Int {
        return stocklist.size
    }
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val CardView: CardView = itemView.findViewById(R.id.MyProfileStockCardView)
        val ScStockName: TextView = itemView.findViewById(R.id.MyProfileStockCardName)
        val StockPL: TextView =itemView.findViewById(R.id.MyProfilePLStockCard)
        val PriceStock: TextView = itemView.findViewById(R.id.MyProfilePriceStockCardText)
        val Descryition: TextView = itemView.findViewById(R.id.MyProfileDescryptionStockCardText)

    }
}
