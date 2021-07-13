package com.example.network.http

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class Response {
    @SerialName("ResultCode")
    var resultCode: ResultCode = ResultCode.Ok

    @SerialName("Message")
    var message: String? = null
}

fun Response.ok() : Boolean {
    return when(resultCode) {
        ResultCode.Ok -> true
        ResultCode.DeprecatedClientWarning -> true
        else -> false
    }
}