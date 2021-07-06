package com.example.network.model

import kotlinx.serialization.Serializable

@Serializable
data class HelloResult (
    override var ResultCode: Int = 0,
    override var Message: String? = null,
    val BuildMajor: Long = 0,
    val BuildMinor: Long = 0
) : BaseResult()