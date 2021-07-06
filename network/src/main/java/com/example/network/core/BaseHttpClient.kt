package com.example.network.core

import com.example.network.model.base.BaseResult
import com.example.network.model.base.ResultCode
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
            httpErrorResult(exception)
        }
        catch (throwable: Throwable) {
            exceptionResult(throwable)
        }
    }

    inline fun <reified T : BaseResult> httpErrorResult(exception: ResponseException) : T {
        val result = T::class.java.newInstance() as BaseResult
        val status = exception.response.status
        result.resultCode = ResultCode.HttpError
        result.message = "HttpStatus = ${status.value}. ${status.description}"
        return result as T
    }

    inline fun <reified T : BaseResult> exceptionResult(throwable: Throwable) : T {
        throwable.printStackTrace()
        val result = T::class.java.newInstance() as BaseResult
        result.resultCode = ResultCode.Exception
        result.message = throwable.message ?: "Internal error"
        return result as T
    }

}