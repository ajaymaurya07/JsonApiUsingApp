package com.example.fakestoreapiapp

import com.example.fakestoreapiapp.ApiModel.ProductItem

interface ProductItemlistner {

    fun itemonclick(position:Int,data:ProductItem)

}