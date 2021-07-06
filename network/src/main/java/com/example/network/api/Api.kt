package com.example.network.api

import com.example.network.model.result.HelloResult

interface Api {
    suspend fun hello(username: String) : HelloResult
    suspend fun longOperationWithProgress(block: (Int) -> Unit)
}