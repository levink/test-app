package com.example.network.core

import com.example.network.model.BaseResult
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

open class BaseHttpClient (
    val endpoint: String,
    val httpClient: HttpClient
) {
    suspend inline fun <reified T : BaseResult> get(
        operation: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): T {
        val url = "${endpoint}${operation}"
        return try {
            val response: HttpResponse = httpClient.get(url) {
                block()
            }
            response.receive()
        }
        catch (exception: ResponseException) {
            errorResult(exception)
        }
        catch (throwable: Throwable) {
            errorResult(throwable)
        }
    }

    inline fun <reified T : BaseResult> errorResult(exception: ResponseException) : T {
        val result = T::class.java.newInstance() as BaseResult
        val status = exception.response.status
        result.ResultCode = status.value
        result.Message = status.description
        return result as T
    }

    inline fun <reified T : BaseResult> errorResult(throwable: Throwable) : T {
        throwable.printStackTrace()
        val result = T::class.java.newInstance() as BaseResult
        result.ResultCode = 100500
        result.Message = throwable.message ?: "Internal error"
        return result as T
    }

}