package com.example.testapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.network.api.Provider

class MainViewModelFactory (
    private val apiProvider: Provider
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == MainViewModel::class.java) {
            val api = apiProvider.getApi()
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(api) as T
        }
        throw IllegalArgumentException("Bad ViewModel class")
    }
}