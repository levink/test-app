package com.example.network.util

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseApiClient (
    val endpoint: String,
    val httpClient: HttpClient
){

    suspend inline fun <reified T> get(
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

}