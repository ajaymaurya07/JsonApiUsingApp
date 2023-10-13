package com.example.fakestoreapiapp.ApimodelMovie

import com.google.gson.annotations.SerializedName

data class MoviesItem(

    @SerializedName("poster_path")
    var poster_path:String,


    @SerializedName("overview")
    var overview:String,

    @SerializedName("original_title")
    var original_title:String,

    @SerializedName("original_language")
    var original_language:String,

    @SerializedName("release_date")
    var release_date:String,

    @SerializedName("vote_average")
    var vote_average:Double
)
