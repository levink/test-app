package com.example.network.model

import com.example.network.core.Response
import kotlinx.serialization.Serializable

@Serializable
data class HelloResult (
    val BuildMajor: Long = 0,
    val BuildMinor: Long = 0
) : Response()