package com.example.testapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UserViewModelFactory (
    private val api : SkiMapInterface
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == UserViewModel::class.java) {
            return UserViewModel(api) as T
        }
        throw IllegalArgumentException("Bad ViewModel class")
    }
}