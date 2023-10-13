package com.example.fakestoreapiapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakestoreapiapp.ApiModel.UserList
import com.example.fakestoreapiapp.databinding.UserPrototypeBinding

class RecylerAdapterUser(var list: UserList) : RecyclerView.Adapter<RecylerAdapterUser.MyViewHolder>() {

    inner class MyViewHolder( var binding: UserPrototypeBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var binding = UserPrototypeBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)


    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var data = list[position]
        holder.binding.name.text="Name: ${data.name.firstname } ${data.name.lastname } "
        holder.binding.username.text="UserName: ${data.username }"
        holder.binding.phoneno.text="Phone-no: ${data.phone }"
        holder.binding.mailid.text="Mail-id: ${data.email }"
        holder.binding.address.text="Address: ${data.address.street} ${data.address.number} ${data.address.city} ${data.address.zipcode}"


    }
}
