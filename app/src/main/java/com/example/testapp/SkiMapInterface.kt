package com.example.testapp

import retrofit2.http.GET
import retrofit2.http.Query

interface SkiMapInterface {
    @GET("Hello")
    suspend fun hello(@Query("username") username: String) : HelloResponse
}

