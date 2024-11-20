package com.example.apiuse

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MyAdapter(val contx : Activity, private val productList : List<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
   val itemView = LayoutInflater.from(contx).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return  productList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.title.text = currentItem.title
        holder.warranty.text = currentItem.warrantyInformation
        holder.price.text = String.format("Price: $%#.2f", currentItem.price) // Format price to 2 decimal places
        holder.rating.text = String.format("Rating: %.1f", currentItem.rating) // Format rating to 1 decimal place
        holder.discount.text = "Discount: ${currentItem.discountPercentage}%"

     // How to show image in image view if the image is in form of url, use picasso library
       Glide.with(contx).load(currentItem.thumbnail).into(holder.image)

    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var title = itemView.findViewById<TextView>(R.id.productTittle)
        var image = itemView.findViewById<ImageView>(R.id.productImage)
        var warranty = itemView.findViewById<TextView>(R.id.warranty)
        var price = itemView.findViewById<TextView>(R.id.price)
        var rating = itemView.findViewById<TextView>(R.id.rating)
        var discount = itemView.findViewById<TextView>(R.id.diss)
    }
}