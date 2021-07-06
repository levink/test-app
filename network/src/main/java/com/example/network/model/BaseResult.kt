package com.example.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
open class BaseResult {
    @SerialName("ResultCode")
    var resultCode: ResultCode = ResultCode.Ok

    @SerialName("Message")
    var message: String? = null
}

