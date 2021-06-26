package com.example.testapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testapp.skimap.api.SkiMapProvider

class UserViewModelFactory (
    private val apiProvider: SkiMapProvider
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == UserViewModel::class.java) {
            val api = apiProvider.getApi()
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(api) as T
        }
        throw IllegalArgumentException("Bad ViewModel class")
    }
}