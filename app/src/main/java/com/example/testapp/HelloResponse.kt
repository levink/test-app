package com.example.testapp

import com.google.gson.annotations.SerializedName

data class HelloResponse (
    @SerializedName("Message")
    val message: String,

    @SerializedName("ResultCode")
    val resultCode: Long,

    @SerializedName("BuildMajor")
    val buildMajor: Long,

    @SerializedName("BuildMinor")
    val buildMinor: Long
)