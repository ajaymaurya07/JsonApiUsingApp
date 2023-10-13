package com.example.fakestoreapiapp.currency

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CurrencyApiMethod {

    @Headers(
        "X-RapidAPI-Key: 91e3b5fadbmsh1be274b8b732bf9p1d3438jsnd66fe3944c8b",
        "X-RapidAPI-Host: currency-exchange.p.rapidapi.com"
    )
    @GET("/exchange")
    fun convertCurrency(
        @Query("from") from: String?,
        @Query("to") to: String?,
        @Query("q") quantity: Int
    ): Call<Double?>?
}
