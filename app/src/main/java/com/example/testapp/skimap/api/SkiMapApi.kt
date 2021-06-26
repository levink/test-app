package com.example.testapp.skimap.api

import com.example.testapp.skimap.model.HelloResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SkiMapApi (
    private val endpoint: String,
    private val httpClient: HttpClient,
) : SkiMapInterface {

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
}