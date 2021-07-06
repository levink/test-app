package com.example.testapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.network.api.ApiClient
import com.example.network.core.HttpClientProvider

class MainViewModelFactory (
    private val httpClientProvider: HttpClientProvider
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == MainViewModel::class.java) {
            val baseUrl = httpClientProvider.endpoint()
            val httpClient = httpClientProvider.client()
            val apiClient = ApiClient(baseUrl, httpClient)
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(apiClient) as T
        }
        throw IllegalArgumentException("Bad ViewModel class")
    }
}