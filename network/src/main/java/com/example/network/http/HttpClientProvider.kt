package com.example.network.http

import io.ktor.client.*

interface HttpClientProvider {
    fun client() : HttpClient
    fun endpoint() : String
}