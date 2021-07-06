package com.example.network.core

import io.ktor.client.*

interface HttpClientProvider {
    fun client() : HttpClient
    fun endpoint() : String
}