package com.example.network.api

import com.example.network.core.BaseHttpClient
import com.example.network.model.result.HelloResult
import com.example.network.model.result.MapListRequest
import com.example.network.model.result.MapListResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.delay

class ApiClient (
    endpoint: String,
    httpClient: HttpClient,
) : BaseHttpClient(endpoint, httpClient), Api {

    override suspend fun hello(username: String): HelloResult {
        return get("Hello") {
            parameter("username", username)
        }
    }

    override suspend fun mapList(request: MapListRequest): MapListResponse {
        return post("GetMapList", request)
    }

    override suspend fun longOperationWithProgress(block: (Int) -> Unit) {
        repeat(100) {
            block(it)
            delay(25)
        }
        block(100)
    }
}