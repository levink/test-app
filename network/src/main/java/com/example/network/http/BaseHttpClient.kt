package com.example.network.http

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.utils.*
import io.ktor.http.*

open class BaseHttpClient (
    val endpoint: String,
    val httpClient: HttpClient
) {
    suspend inline fun <reified T : Response> get(
        path: String,
        crossinline block: HttpRequestBuilder.() -> Unit = {}
    ): T {
        val url = "${endpoint}${path}"
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

    suspend inline fun <reified T : Response> post(
        path: String,
        data: Any = { EmptyContent }
    ): T {
        val url = "${endpoint}${path}"
        return try {
            val response: HttpResponse = httpClient.post(url) {
                contentType(ContentType.Application.Json)
                body = data
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

    inline fun <reified T : Response> httpErrorResult(exception: ResponseException) : T {
        val result = T::class.java.newInstance() as Response
        val status = exception.response.status
        result.resultCode = ResultCode.HttpError
        result.message = "HttpStatus = ${status.value}. ${status.description}"
        return result as T
    }

    inline fun <reified T : Response> exceptionResult(throwable: Throwable) : T {
        throwable.printStackTrace()
        val result = T::class.java.newInstance() as Response
        result.resultCode = ResultCode.Exception
        result.message = throwable.message ?: "Internal error"
        return result as T
    }

}