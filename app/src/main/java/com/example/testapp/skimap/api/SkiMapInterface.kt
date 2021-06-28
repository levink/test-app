package com.example.testapp.skimap.api

import com.example.testapp.skimap.model.HelloResponse

interface SkiMapInterface {
    suspend fun hello(username: String) : HelloResponse
    suspend fun progress(block: (Int) -> Unit)
}