package com.example.fakestoreapiapp

import com.example.fakestoreapiapp.ApiModel.ProductList
import com.example.fakestoreapiapp.ApiModel.UserList
import retrofit2.Call
import retrofit2.http.GET

interface ApiMethod {
    @GET("/products")

    fun getproduct():Call<ProductList>

    @GET("/users")

    fun getUser():Call<UserList>

}