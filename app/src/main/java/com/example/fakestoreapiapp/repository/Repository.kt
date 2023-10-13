package com.example.fakestoreapiapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.fakestoreapiapp.ApiModel.ProductList
import com.example.fakestoreapiapp.ApiModel.UserList
import com.example.fakestoreapiapp.ApimodelMovie.MovieResult
import com.example.fakestoreapiapp.retroffits.Myretrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private var livedata: MutableLiveData<ProductList> = MutableLiveData()
    var isloading = MutableLiveData<Boolean>().apply {
        value=true
    }
    fun getProduct(): MutableLiveData<ProductList> {

        val call = Myretrofit().apiCall.getproduct()
        call.enqueue(object : Callback<ProductList> {
            override fun onResponse(call: Call<ProductList>, response: Response<ProductList>) {
                if (response.isSuccessful) {
                    livedata.value=response.body()
                    isloading.value=false
                }
            }

            override fun onFailure(call: Call<ProductList>, t: Throwable) {
                isloading.value=false
            }
        })
        return livedata
    }


    private var livedatauser: MutableLiveData<UserList> = MutableLiveData()
    var isloadinguser = MutableLiveData<Boolean>().apply {
        value=true
    }
    fun getProductuser(): MutableLiveData<UserList> {

        val call = Myretrofit().apiCall.getUser()
        call.enqueue(object : Callback<UserList> {
            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                if (response.isSuccessful) {
                    livedatauser.value=response.body()
                    isloadinguser.value=false
                }
            }

            override fun onFailure(call: Call<UserList>, t: Throwable) {
                isloading.value=false
            }
        })
        return livedatauser
    }



    private var livedatamovie: MutableLiveData<MovieResult> = MutableLiveData()
    var isloadingmovie = MutableLiveData<Boolean>().apply {
        value=true
    }
    fun getProductmovie(): MutableLiveData<MovieResult> {

        val call = Myretrofit().apiCallmovie.getmovies(apiKey= "6282fb1a6565574009fa32e262118eb7")
        call.enqueue(object : Callback<MovieResult> {
            override fun onResponse(call: Call<MovieResult>, response: Response<MovieResult>) {
                if (response.isSuccessful) {
                    livedatamovie.value=response.body()
                    isloadingmovie.value=false
                }
            }

            override fun onFailure(call: Call<MovieResult>, t: Throwable) {
                isloading.value=false
            }
        })
        return livedatamovie
    }


}
