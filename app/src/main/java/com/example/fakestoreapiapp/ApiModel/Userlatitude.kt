package com.example.fakestoreapiapp.ApiModel

import com.google.gson.annotations.SerializedName

data class Userlatitude(


    @SerializedName("lat")
    var latitude:String,

    @SerializedName("long")
    var longitude:String

)