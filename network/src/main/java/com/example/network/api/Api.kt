package com.example.network.api

import com.example.network.model.HelloResult
import com.example.network.model.MapListRequest
import com.example.network.model.MapListResponse

interface Api {
    suspend fun hello(username: String) : HelloResult
    suspend fun mapList(request: MapListRequest) : MapListResponse
    suspend fun longOperationWithProgress(block: (Int) -> Unit)
}