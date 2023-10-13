package com.example.fakestoreapiapp.currency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fakestoreapiapp.R
import com.example.fakestoreapiapp.databinding.ActivityCurrencyBinding

class CurrencyActivity : AppCompatActivity() {
    lateinit var binding: ActivityCurrencyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_currency)

        val viewModel = ViewModelProvider(this)[CurrencyViewModel::class.java]
        val temp = viewModel.convertCurrency("USD", "INR", 1)

        temp.observe(this, Observer {
            binding.tvDisplay.text = it.toString()
        })
    }
}
