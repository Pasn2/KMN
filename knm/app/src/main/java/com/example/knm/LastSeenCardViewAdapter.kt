package com.example.knm

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class LastSeenCardViewAdapter(private val stocklist: ArrayList<StockData>): RecyclerView.Adapter<LastSeenCardViewAdapter.MyViewHolder>() {


    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastSeenCardViewAdapter.MyViewHolder {

        context = parent.context
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.stock_card,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LastSeenCardViewAdapter.MyViewHolder, position: Int) {

        val currentItem = stocklist[position]
        holder.ScStockName.text = currentItem.ShortcutName
        holder.Descryition.text = currentItem.Descryption

        val cardview = holder.CardView
        cardview.setOnClickListener{

            val changetostockdetailsintent = Intent(context,stock_char_view::class.java)
            context.startActivity(changetostockdetailsintent)
        }
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
        val BuyBtn: Button = itemView.findViewById(R.id.BuyStockCardBtn)
        val SellBtn: Button = itemView.findViewById(R.id.SellStockCardBtn)
    }
}