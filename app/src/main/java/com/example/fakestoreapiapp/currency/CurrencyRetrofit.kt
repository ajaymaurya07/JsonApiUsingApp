package com.example.fakestoreapiapp.currency

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CurrencyRetrofit {

    private val gson = GsonBuilder().create()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://currency-exchange.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val apiCall: CurrencyApiMethod by lazy {
        retrofit.create(CurrencyApiMethod::class.java)
    }
}
