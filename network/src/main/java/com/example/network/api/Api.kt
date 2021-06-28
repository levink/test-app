package com.example.network.api

import com.example.network.model.HelloResponse

interface Api {
    suspend fun hello(username: String) : HelloResponse
    suspend fun longProgressCall(block: (Int) -> Unit)
}