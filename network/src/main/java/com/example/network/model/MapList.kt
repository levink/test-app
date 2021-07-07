package com.example.network.model

import com.example.network.core.Response
import kotlinx.serialization.Serializable

@Serializable
data class MapListRequest(
    val clientVersion: Int,
    val language: Int,
    val terrainFormat: Int,
    val objectsFormat: Int
)

@Serializable
data class MapListResponse (
    val Items: List<MapItem> = emptyList()
) : Response()

@Serializable
data class MapItem (
    val Id: Int = 0,
    val Name: String = "",
    val TerrainFormat: Int = 0,
    val TerrainVersion: Int = 0
    //... and so on
)