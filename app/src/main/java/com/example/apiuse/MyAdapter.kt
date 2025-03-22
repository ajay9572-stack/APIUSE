package com.example.apiuse

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apiuse.databinding.EachitemBinding

class MyAdapter(
    private val dataList: Any,
    private val context: Activity

):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            EachitemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList[position]
        val binding = (holder as ViewHolder).binding
        binding.productTittle.text = item.title
        Glide.with(context).load(item.photo_url).into(binding.productImage)
    }


    override fun getItemCount(): Int {
        return dataList.size
    }
    class ViewHolder(val binding:EachitemBinding) : RecyclerView.ViewHolder(binding.root){

    }
}
