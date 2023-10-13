package com.example.fakestoreapiapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiactivity.Adapter.RecylerApter
import com.example.apiactivity.FetchDataModelClass.MyViewModel
import com.example.fakestoreapiapp.ApiModel.ProductItem
import com.example.fakestoreapiapp.ApiModel.ProductList
import com.example.fakestoreapiapp.databinding.ActivityProductPageBinding
import com.google.gson.Gson

class ProductPageActivity : AppCompatActivity(), ProductItemlistner {
    lateinit var binding:ActivityProductPageBinding
    lateinit var list:ProductList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_product_page)

        var model=ViewModelProvider(this)[MyViewModel::class.java]

        var dialog=ProgressDialog(this)
        dialog.setMessage("Loading..Plz wait...")
        dialog.setCancelable(false)



        model.isloading.observe(this, Observer {
            if(it){
                dialog.show()
            }
            else{
                dialog.dismiss()
            }
        })

        model.getUsers()!!.observe(this, Observer {
            list=it
            binding.recylerView.layoutManager=LinearLayoutManager(this)
            var myadapter=RecylerApter(it,this)
            binding.recylerView.adapter=myadapter

            Log.d("TAG", "${it.size} ")

        })


    }

    override fun itemonclick(position: Int, data: ProductItem) {
        var intent=Intent(this,ProductItemShow::class.java)
        intent.putExtra("data",Gson().toJson(data))
        startActivity(intent)
    }


//
}