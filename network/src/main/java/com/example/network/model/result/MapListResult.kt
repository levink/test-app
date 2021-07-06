package com.example.network.model.result

import com.example.network.model.base.BaseResult
import kotlinx.serialization.Serializable

@Serializable
data class MapListRequest(
    val clientVersion: Int,
    val language: Int,
    val terrainFormat: Int,
    val objectsFormat: Int
)

@Serializable
data class MapListResult (
    val Items: List<MapItem> = emptyList()
) : BaseResult()

@Serializable
data class MapItem (
    val Id: Int = 0,
    val Name: String = "",
    val TerrainFormat: Int = 0,
    val TerrainVersion: Int = 0
    //... and so on
)