package com.nextin.cartapiapplication

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val context: Activity, private val cartList: ArrayList<Cart>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    class MyViewHolder(itemView :View):RecyclerView.ViewHolder(itemView){
        val id = itemView.findViewById<TextView>(R.id.tvId)
        val userId = itemView.findViewById<TextView>(R.id.userId)
        val total = itemView.findViewById<TextView>(R.id.tvTotal)
        val totalProduct = itemView.findViewById<TextView>(R.id.totalProducts)
        val totalDiscount = itemView.findViewById<TextView>(R.id.discountedTotal)
        val totalqty = itemView.findViewById<TextView>(R.id.totalQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.each_item_view,parent ,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentData = cartList[position]
        holder.id.text = currentData.id.toString()
        holder.userId.text= currentData.userId.toString()
        holder.totalqty.text = currentData.totalQuantity.toString()
        holder.total.text = currentData.total.toString()
        holder.totalProduct.text = currentData.totalProducts.toString()
        holder.totalDiscount.text = currentData.discountedTotal.toString()
    }
}