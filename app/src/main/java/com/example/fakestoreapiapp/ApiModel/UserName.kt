package com.example.fakestoreapiapp.ApiModel

import com.google.gson.annotations.SerializedName

data class UserName(
    @SerializedName("firstname")
    var firstname:String,

    @SerializedName("lastname")
    var lastname:String

)