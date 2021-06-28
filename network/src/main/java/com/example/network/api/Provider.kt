package com.example.network.api

import androidx.lifecycle.ViewModel
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

class Provider : ViewModel() {

    private val baseUrl = "https://snowrider.pro:1305/skimap/"

    private val client : HttpClient by lazy { createClient() }

    private val api : Client by lazy { Client(baseUrl, client) }

    private fun createClient(): HttpClient {
        return HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    fun getApi(): Api {
        return api
    }

    override fun onCleared() {
        super.onCleared()
        client.close()
    }
}