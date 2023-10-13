package com.example.fakestoreapiapp.ApiModel

import com.google.gson.annotations.SerializedName


data class UsersItem(
    @SerializedName("address")
    var address:UserLocation,

    @SerializedName("email")
    var email:String,

    @SerializedName("username")
    var username:String,

    @SerializedName("name")
    var name:UserName,

    @SerializedName("phone")
    var phone:String


)


