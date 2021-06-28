package com.example.testapp.skimap.api

import com.example.testapp.skimap.model.HelloResponse

interface Api {
    suspend fun hello(username: String) : HelloResponse
    suspend fun progress(block: (Int) -> Unit)
}