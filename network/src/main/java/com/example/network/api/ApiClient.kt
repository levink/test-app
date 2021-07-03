package com.example.network.api

import com.example.network.base.BaseHttpClient
import com.example.network.model.HelloResponse
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class ApiClient (
    endpoint: String,
    httpClient: HttpClient,
) : BaseHttpClient(endpoint, httpClient), Api {

    override suspend fun hello(username: String) : HelloResponse {
        return get("Hello") {
            parameter("username", username)
        }
    }

    override suspend fun longProgressCall(block: (Int) -> Unit) {
        withContext(Dispatchers.Default) {
            repeat(100) {
                block(it)
                delay(25)
            }
            block(100)
        }
    }
}