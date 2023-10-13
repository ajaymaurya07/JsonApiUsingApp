package com.example.fakestoreapiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.fakestoreapiapp.ApiModel.ProductItem
import com.example.fakestoreapiapp.databinding.ActivityProductItemShowBinding
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class ProductItemShow : AppCompatActivity() {
    lateinit var binding:ActivityProductItemShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_product_item_show)
        var data=intent
        var proitem=data.getStringExtra("data")
        var productitem=Gson().fromJson(proitem,ProductItem::class.java)


        binding.title.text= "Title: ${ productitem.title }"
        binding.price.text="Price: ${productitem.price}$"
        binding.category.text="Category: ${productitem.category}"
        binding.discription.text="Discription: ${productitem.description}"
        Picasso.get().load(productitem.image).into(binding.imageView)


    }
}