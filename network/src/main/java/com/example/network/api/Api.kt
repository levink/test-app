package com.example.network.api

import com.example.network.model.HelloResponse

interface ApiProvider {
    fun getApi() : Api
}

interface Api {
    suspend fun hello(username: String) : HelloResponse
    suspend fun longProgressCall(block: (Int) -> Unit)
}