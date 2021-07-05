package com.example.network.base

import io.ktor.client.*

interface HttpClientProvider {
    fun get() : HttpClient
}