package com.example.fakestoreapiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.fakestoreapiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.cart.setOnClickListener {
            var intent=Intent(this,CartPageActivity::class.java)
            startActivity(intent)
        }
        binding.product.setOnClickListener {
            var intent=Intent(this,ProductPageActivity::class.java)
            startActivity(intent)
        }

    }
}