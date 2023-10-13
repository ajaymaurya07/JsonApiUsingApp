package com.example.fakestoreapiapp

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiactivity.Adapter.RecylerApter
import com.example.apiactivity.FetchDataModelClass.MyViewModel
import com.example.fakestoreapiapp.adapter.RecylerAdapterUser
import com.example.fakestoreapiapp.databinding.ActivityCartPageBinding

class CartPageActivity : AppCompatActivity() {
    lateinit var binding:ActivityCartPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_cart_page)

        var model= ViewModelProvider(this)[MyViewModel::class.java]

        var dialog= ProgressDialog(this)
        dialog.setMessage("Loading..Plz wait...")
        dialog.setCancelable(false)

        model.isloadinguser.observe(this, Observer {
            if(it){
                dialog.show()
            }
            else{
                dialog.dismiss()
            }
        })

        model.getUsersdata()!!.observe(this, Observer {

            binding.recyler.layoutManager= LinearLayoutManager(this)
            var myadapter= RecylerAdapterUser(it)
            binding.recyler.adapter=myadapter

            Log.d("TAG", "${it.size} ")

        })

    }
}