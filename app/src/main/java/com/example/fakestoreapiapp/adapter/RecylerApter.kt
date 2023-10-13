package com.example.apiactivity.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakestoreapiapp.ApiModel.ProductList
import com.example.fakestoreapiapp.ProductItemlistner
import com.example.fakestoreapiapp.databinding.PrototypeBinding
import com.squareup.picasso.Picasso


class RecylerApter( var list: ProductList,var productItemlistner: ProductItemlistner) : RecyclerView.Adapter<RecylerApter.MyViewHolder>() {

    inner class MyViewHolder( var binding:PrototypeBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var binding = PrototypeBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)


    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var data = list[position]
        holder.binding.category.text = data.category
        holder.binding.title.text = data.title
        holder.binding.price.text="${data.price}$"
        Picasso.get().load(data.image).into(holder.binding.imageView)

        holder.binding.cardLayout.setOnClickListener {
            productItemlistner.itemonclick(position,list[position])
        }

    }
}
