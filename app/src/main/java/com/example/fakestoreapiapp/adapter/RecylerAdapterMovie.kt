package com.example.fakestoreapiapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakestoreapiapp.ApimodelMovie.MovieResult
import com.example.fakestoreapiapp.databinding.MoviePrototypeBinding
import com.squareup.picasso.Picasso

class RecylerAdapterMovie(var list: MovieResult) : RecyclerView.Adapter<RecylerAdapterMovie.MyViewHolder>() {

    inner class MyViewHolder( var binding: MoviePrototypeBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var binding = MoviePrototypeBinding.inflate(inflater, parent, false)
        return MyViewHolder(binding)


    }

    override fun getItemCount(): Int {
        return list.results.size
        Log.d("TAG", "getItemCount: ${list.results.size}")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var data = list.results
        var count=list.results.size
//        for (i in 0..count){
//            holder.binding.textView.text=data[i].overview
//        }


//        holder.binding.textView.text=data[position].overview
        holder.binding.title.text="Title : ${data[position].original_title}"
        holder.binding.overview.text="Overvew : ${data[position].overview}"
        holder.binding.languge.text="Languege : ${data[position].original_language}"
        holder.binding.vote.text="Rating : ${data[position].vote_average.toString()}"
        holder.binding.releaseDate.text="ReleaseDate : ${data[position].release_date}"
        Picasso.get().load("https://image.tmdb.org/t/p/w500${data[position].poster_path}").into(holder.binding.posterPath)
//        https://image.tmdb.org/t/p/w500/kdPMUMJzyYAc4roD52qavX0nLIC.jpg
//        holder.binding.username.text="UserName: ${data.username }"
//        holder.binding.phoneno.text="Phone-no: ${data.phone }"
//        holder.binding.mailid.text="Mail-id: ${data.email }"
//        holder.binding.address.text="Address: ${data.address.street} ${data.address.number} ${data.address.city} ${data.address.zipcode}"


    }
}