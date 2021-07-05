package com.example.testapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.network.api.Api
import com.example.network.api.ApiClient
import com.example.network.base.HttpClientProvider

class MainViewModelFactory (
    private val httpClientProvider: HttpClientProvider
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == MainViewModel::class.java) {
            val httpClient = httpClientProvider.get()
            val apiClient = ApiClient(BuildConfig.BASE_URL, httpClient)
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(apiClient) as T
        }
        throw IllegalArgumentException("Bad ViewModel class")
    }
}