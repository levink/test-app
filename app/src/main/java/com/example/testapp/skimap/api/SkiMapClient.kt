package com.example.testapp.skimap.api

import androidx.lifecycle.ViewModel
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

class SkiMapClient : ViewModel(), SkiMapProvider {

    private val baseUrl = "https://snowrider.pro:1305/skimap/"

    private val client : HttpClient by lazy { createClient() }

    private val api : SkiMapApi by lazy { SkiMapApi(baseUrl, client) }

    private fun createClient(): HttpClient {
        return HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    override fun getApi(): SkiMapInterface {
        return api
    }

    override fun onCleared() {
        super.onCleared()
        client.close()
    }
}