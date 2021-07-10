package com.example.network.model

import com.example.network.core.Response
import kotlinx.serialization.Serializable

data class HelloRequest (
    val userName: String
)

@Serializable
data class HelloResponse (
    val BuildMajor: Long = 0,
    val BuildMinor: Long = 0
) : Response()