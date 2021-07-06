package com.example.network.model

import kotlinx.serialization.Serializable

@Serializable
data class HelloResult (
    val BuildMajor: Long = 0,
    val BuildMinor: Long = 0
) : BaseResult()