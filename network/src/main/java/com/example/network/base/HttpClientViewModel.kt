package com.example.network.base

import androidx.lifecycle.ViewModel
import io.ktor.client.*

class HttpClientViewModel(
    private val httpClient: HttpClient
): ViewModel(), HttpClientProvider {
    override fun get(): HttpClient {
        return httpClient
    }
    override fun onCleared() {
        super.onCleared()
        httpClient.close()
    }
}