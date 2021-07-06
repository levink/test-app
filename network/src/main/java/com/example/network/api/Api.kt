package com.example.network.api

import com.example.network.model.HelloResult

interface Api {
    suspend fun hello(username: String) : HelloResult
    suspend fun longProgressCall(block: (Int) -> Unit)
}