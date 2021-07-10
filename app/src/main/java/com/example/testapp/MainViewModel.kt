package com.example.testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.model.HelloRequest
import com.example.network.model.HelloResponse
import com.example.network.model.MapItem
import com.example.network.model.MapListRequest
import kotlinx.coroutines.*

class MainViewModel (
    private val repo: MapsRepo,
    private val progress: MutableLiveData<Int> = MutableLiveData(),
) : ViewModel() {

    fun getProgress() : LiveData<Int> = progress

    fun getMapList() : LiveData<List<MapItem>> = repo.mapList

    fun updateMaps() {
        viewModelScope.launch {

            val work1 = async (Dispatchers.IO) {
                repo.updateMapList(MapListRequest(
                    clientVersion = 0,
                    language = 0,
                    terrainFormat = 1,
                    objectsFormat = 1
                ))
            }

            val work2 = async(Dispatchers.Default) {
                for(i in 0..101) {
                    delay(25)
                    progress.postValue(i)
                }
            }
        }
    }
}




















