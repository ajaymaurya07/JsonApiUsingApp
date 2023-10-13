package com.example.apiactivity.FetchDataModelClass

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fakestoreapiapp.ApiModel.ProductList
import com.example.fakestoreapiapp.ApiModel.UserList
import com.example.fakestoreapiapp.ApimodelMovie.MovieList
import com.example.fakestoreapiapp.ApimodelMovie.MovieResult
import com.example.fakestoreapiapp.repository.Repository

class MyViewModel : ViewModel() {
    private val repository = Repository()
    var isloading=repository.isloading
    var isloadinguser=repository.isloadinguser

    var isloadingmovie=repository.isloadingmovie

    fun getUsers(): MutableLiveData<ProductList> {
        var liveData = repository.getProduct()
        return liveData
    }

    fun getUsersdata(): MutableLiveData<UserList> {
        var liveData = repository.getProductuser()
        return liveData
    }

    fun getUsersMovie(): MutableLiveData<MovieResult> {
        var liveData = repository.getProductmovie()
        return liveData
    }

}
