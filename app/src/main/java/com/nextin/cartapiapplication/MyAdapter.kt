package com.nextin.cartapiapplication

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity ,val cartList: ArrayList<Product>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    class MyViewHolder(itemView :View):RecyclerView.ViewHolder(itemView){
        var title = itemView.findViewById<TextView>(R.id.tvTitle)
        var price = itemView.findViewById<TextView>(R.id.tvPrice)
        var image = itemView.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item_view,parent ,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentData = cartList[position]

        holder.title.text = currentData.title
        holder.price.text= currentData.price.toString()
        Picasso.get().load(currentData.thumbnail).into(holder.image);

    }
}