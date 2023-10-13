package com.example.fakestoreapiapp.currency

import CurrencyRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CurrencyViewModel : ViewModel() {

    private val repository = CurrencyRepository()

    var liveData: MutableLiveData<Double?> = MutableLiveData()

    fun convertCurrency(from: String?, to: String?, quantity: Int): LiveData<Double?> {
        val temp = repository.convertCurrency(from, to, quantity)
        liveData.value = temp.value

        return temp
    }
}
