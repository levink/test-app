package com.example.network.core

import androidx.lifecycle.ViewModel
import io.ktor.client.*

class HttpClientViewModel(
    private val endpoint: String,
    private val httpClient: HttpClient
): ViewModel(), HttpClientProvider {
    override fun onCleared() {
        super.onCleared()
        httpClient.close()
    }

    override fun endpoint(): String  = endpoint

    override fun client(): HttpClient = httpClient
}