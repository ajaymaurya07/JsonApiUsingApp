package com.example.fakestoreapiapp.ApimodelMovie

import com.google.gson.annotations.SerializedName

data class MovieResult(

    @SerializedName("results")
     var results:ArrayList<MoviesItem>

)

