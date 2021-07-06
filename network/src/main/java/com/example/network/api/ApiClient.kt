package com.example.network.api

import com.example.network.core.BaseHttpClient
import com.example.network.model.HelloResult
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.delay

class ApiClient (
    endpoint: String,
    httpClient: HttpClient,
) : BaseHttpClient(endpoint, httpClient), Api {

    override suspend fun hello(username: String): HelloResult {
        return get("Hello") {
            parameter("username", username)
        }
    }

    override suspend fun longProgressCall(block: (Int) -> Unit) {
        repeat(100) {
            block(it)
            delay(25)
        }
        block(100)
    }
}