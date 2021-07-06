package com.example.network.api

import com.example.network.model.result.HelloResult
import com.example.network.model.result.MapListRequest
import com.example.network.model.result.MapListResponse

interface Api {
    suspend fun hello(username: String) : HelloResult
    suspend fun mapList(request: MapListRequest) : MapListResponse
    suspend fun longOperationWithProgress(block: (Int) -> Unit)
}