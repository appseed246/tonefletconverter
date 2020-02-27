package com.example.tonefletconverter.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object {
        const val TAG = "MainViewModel"
    }

    private val _counter: MutableLiveData<Int> = MutableLiveData(0)

    val counter: LiveData<Int> = _counter

    fun addCounter() {
        _counter.value = (_counter.value ?: 0) + 1
        Log.w(TAG, "addCounter()/value:${counter.value}")
    }
}
