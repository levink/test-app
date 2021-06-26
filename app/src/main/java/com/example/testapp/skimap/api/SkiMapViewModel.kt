package com.example.testapp.skimap.api

import androidx.lifecycle.ViewModel
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

class SkiMapViewModel : ViewModel(), SkiMapProvider {

    private val baseUrl = "https://snowrider.pro:1305/skimap/"

    private val client : HttpClient by lazy {
        HttpClient(CIO) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    ignoreUnknownKeys = true
                })
            }
        }

    }

    private val api : SkiMapApi by lazy { SkiMapApi(baseUrl, client) }

    override fun getApi(): SkiMapInterface {
        return api
    }

    override fun onCleared() {
        super.onCleared()
        client.close()
    }
}