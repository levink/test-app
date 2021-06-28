package com.example.network.api

import com.example.network.model.HelloResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class Client (
    private val endpoint: String,
    private val httpClient: HttpClient,
) : Api {

    private suspend inline fun <reified T> get(
        operation: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): T {
        return withContext(Dispatchers.IO) {
            val url = "${endpoint}${operation}"
            val response: HttpResponse = httpClient.get(url) {
                block()
            }
            response.receive()
        }
    }

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