package com.example.network.api


import com.example.network.http.BaseHttpClient
import com.example.network.model.*
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.delay

class ApiClient (
    endpoint: String,
    httpClient: HttpClient,
) : BaseHttpClient(endpoint, httpClient), Api {

    override suspend fun hello(request: HelloRequest): HelloResponse {
        return get("Hello") {
            parameter("username", request.userName)
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