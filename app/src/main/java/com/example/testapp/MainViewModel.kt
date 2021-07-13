package com.example.testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.model.MapItem
import com.example.network.model.MapListRequest
import kotlinx.coroutines.*

class MainViewModel (
    private val repo: MapsRepo,
    private val progress: MutableLiveData<Int> = MutableLiveData(),
) : ViewModel() {

    fun getProgress() : LiveData<Int> = progress

    fun mapList() : LiveData<List<MapItem>> = repo.mapList

    fun updateMaps() {
        viewModelScope.launch {

            withContext(Dispatchers.IO) {
                repo.updateMapList(MapListRequest(
                    clientVersion = 0,
                    language = 0,
                    terrainFormat = 1,
                    objectsFormat = 1
                ))
            }

            withContext(Dispatchers.Default) {
                for(i in 0..101) {
                    delay(25)
                    progress.postValue(i)
                }
            }
        }
    }
}




















