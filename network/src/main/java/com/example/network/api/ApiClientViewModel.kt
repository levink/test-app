package com.example.network.api

import androidx.lifecycle.ViewModel
import com.example.network.BuildConfig
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

class ApiClientViewModel : ViewModel(), ApiProvider {

    private val httpClient : HttpClient by lazy { createHttpClient() }

    private val apiClient : Api by lazy { createApiClient() }

    private fun createHttpClient(): HttpClient {
        return HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    private fun createApiClient() : Api {
       return ApiClient(BuildConfig.BASE_URL, httpClient)
    }

    override fun getApi(): Api {
        return apiClient
    }

    override fun onCleared() {
        super.onCleared()
        httpClient.close()
    }
}