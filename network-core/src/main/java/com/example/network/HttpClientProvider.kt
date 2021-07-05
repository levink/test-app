package com.example.network

import io.ktor.client.*

interface HttpClientProvider {
    fun client() : HttpClient
    fun endpoint() : String
}