package com.example.fakestoreapiapp.retroffits

import com.example.fakestoreapiapp.ApiMethod
import com.example.fakestoreapiapp.ApiMethodMovie
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Myretrofit {

    private val retrofit: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
    }

    val apiCall:ApiMethod by lazy {
        retrofit.build().create(ApiMethod::class.java)
    }


    private val retrofitmovie: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
    }

    val apiCallmovie:ApiMethodMovie by lazy {
        retrofitmovie.build().create(ApiMethodMovie::class.java)
    }




}