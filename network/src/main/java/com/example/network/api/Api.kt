package com.example.network.api

import com.example.network.model.*

interface Api {
    suspend fun hello(request: HelloRequest) : HelloResponse
    suspend fun mapList(request: MapListRequest) : MapListResponse
    suspend fun longOperationWithProgress(block: (Int) -> Unit)
}