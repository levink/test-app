package com.example.testapp

import androidx.lifecycle.MutableLiveData
import com.example.network.api.Api
import com.example.network.http.ok
import com.example.network.model.MapItem
import com.example.network.model.MapListRequest

class MapsRepo (private val api: Api) {

    val mapList: MutableLiveData<List<MapItem>> = MutableLiveData()
    suspend fun updateMapList(request: MapListRequest){
        val response = api.mapList(request)
        if (response.ok()) {
            mapList.postValue(response.Items)
        }
    }
}