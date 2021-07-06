package com.example.testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.network.api.Api
import com.example.network.model.HelloResult
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
                api.longProgressCall {
                    progress.postValue(it)
                }
            }

            val work2 = async(Dispatchers.IO) {
                api.hello("LevinK")
            }

            work1.await()
            val helloResult = work2.await()
            response.value = helloResult
        }
    }
}




















