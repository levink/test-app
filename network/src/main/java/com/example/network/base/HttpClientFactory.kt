package com.example.network.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

class HttpClientFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == HttpClientViewModel::class.java) {
            @Suppress("UNCHECKED_CAST")
            return HttpClientViewModel(createClient()) as T
        }
        throw IllegalArgumentException("Bad ViewModel class")
    }

    private fun createClient(): HttpClient {
        return HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}