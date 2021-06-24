package com.example.testapp

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object SkiMapService : SkiMapInterface {
    private const val BASE_URL = "https://snowrider.pro:1305/skimap/"

    override suspend fun hello(username: String) : String {
        return withContext(Dispatchers.IO) {
            HttpClient(CIO).use {
                val url = "${BASE_URL}Hello"
                val response: HttpResponse = it.get(url) {
                    parameter("username", username)
                }
                response.receive()
            }
        }
    }
}