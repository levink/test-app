package com.example.network.model

import kotlinx.serialization.Serializable

@Serializable
abstract class BaseResult {
    abstract var ResultCode: Int
    abstract var Message: String?
}

