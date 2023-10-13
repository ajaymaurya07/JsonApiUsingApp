package com.example.fakestoreapiapp.ApiModel

import com.google.gson.annotations.SerializedName

data class UserLocation(

    @SerializedName("geolocation")
    var geolocation:Userlatitude,

    @SerializedName("city")
    var city:String,

    @SerializedName("street")
    var street:String,

    @SerializedName("number")
    var number:Int,

    @SerializedName("zipcode")
    var zipcode:String,



)
