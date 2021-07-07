package com.example.network.core

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class Response {
    @SerialName("ResultCode")
    var resultCode: ResultCode = ResultCode.Ok

    @SerialName("Message")
    var message: String? = null
}