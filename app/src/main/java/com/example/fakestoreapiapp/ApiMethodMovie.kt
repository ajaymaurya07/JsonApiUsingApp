package com.example.fakestoreapiapp

import com.example.fakestoreapiapp.ApimodelMovie.MovieList
import com.example.fakestoreapiapp.ApimodelMovie.MovieResult

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiMethodMovie {
    @GET("/3/movie/popular")
    fun getmovies(@Query("api_key") apiKey: String):Call<MovieResult>
}