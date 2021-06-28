package com.example.network.model

import kotlinx.serialization.Serializable

@Serializable
data class HelloResponse (
    val Message: String,
    val ResultCode: Long,
    val BuildMajor: Long,
    val BuildMinor: Long
)