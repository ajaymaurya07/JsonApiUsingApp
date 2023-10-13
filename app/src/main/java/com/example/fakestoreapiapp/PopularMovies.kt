package com.example.fakestoreapiapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiactivity.FetchDataModelClass.MyViewModel
import com.example.fakestoreapiapp.ApiModel.ProductList
import com.example.fakestoreapiapp.adapter.RecylerAdapterMovie
import com.example.fakestoreapiapp.databinding.ActivityPopularMoviesBinding

class PopularMovies : AppCompatActivity() {
    lateinit var binding: ActivityPopularMoviesBinding
    lateinit var list: ProductList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_popular_movies)

        var model= ViewModelProvider(this)[MyViewModel::class.java]

        var dialog= ProgressDialog(this)
        dialog.setMessage("Loading..Plz wait...")
        dialog.setCancelable(false)



        model.isloadingmovie.observe(this, Observer {
            if(it){
                dialog.show()
            }
            else{
                dialog.dismiss()
            }
        })

        Log.d("TAG", "onCreate: heloo ajju")
        model.getUsersMovie()!!.observe(this, Observer {


            binding.recylerView.layoutManager= LinearLayoutManager(this)
            var myadapter= RecylerAdapterMovie(it)
            binding.recylerView.adapter=myadapter


        })

        Log.d("TAG", "onCreate: heloo ajju")


    }
}