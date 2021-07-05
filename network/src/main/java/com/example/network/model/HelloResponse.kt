package com.example.network.model

import kotlinx.serialization.Serializable

@Serializable
data class HelloResponse (
    val Message: String = "",
    val ResultCode: Long = 0,
    val BuildMajor: Long = 0,
    val BuildMinor: Long = 0
)