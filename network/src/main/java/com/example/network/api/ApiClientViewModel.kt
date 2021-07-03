package com.example.network.api

import androidx.lifecycle.ViewModel
import com.example.network.BuildConfig
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

class ApiClientViewModel : ViewModel(), ApiProvider {

    private val client : HttpClient by lazy { createClient() }

    private val api : ApiClient by lazy { ApiClient(BuildConfig.BASE_URL, client) }

    private fun createClient(): HttpClient {
        return HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    override fun getApi(): Api {
        return api
    }

    override fun onCleared() {
        super.onCleared()
        client.close()
    }
}