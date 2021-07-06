package com.example.testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.api.Api
import com.example.network.model.result.HelloResult
import com.example.network.model.result.MapListRequest
import kotlinx.coroutines.*

class MainViewModel(
    private val api: Api,
    private val progress: MutableLiveData<Int> = MutableLiveData(),
    private val response: MutableLiveData<HelloResult> = MutableLiveData()
) : ViewModel() {

    fun getProgress() : LiveData<Int> = progress

    fun getResponse() : LiveData<HelloResult> = response

    fun askHello() {
        viewModelScope.launch {

            val work1 = async(Dispatchers.Default) {
                api.longOperationWithProgress {
                    progress.postValue(it)
                }
            }

            val work2 = async(Dispatchers.IO) {
                api.hello("LevinK")
            }

            val work3 = async(Dispatchers.IO) {
                api.mapList(MapListRequest(
                    clientVersion = 0,
                    language = 0,
                    terrainFormat = 1,
                    objectsFormat = 1
                ))
            }

            awaitAll(work1, work2, work3)

            val helloResult = work2.await()
            val mapListResult = work3.await()
            response.value = helloResult
        }
    }
}




















