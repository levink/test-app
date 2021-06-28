package com.example.testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.skimap.api.SkiMapInterface
import com.example.testapp.skimap.model.HelloResponse
import kotlinx.coroutines.*

class UserViewModel(
    private val api: SkiMapInterface,
    private val progress: MutableLiveData<Int> = MutableLiveData(),
    private val response: MutableLiveData<HelloResponse> = MutableLiveData()
) : ViewModel() {

    fun getProgress() : LiveData<Int> = progress

    fun getResponse() : LiveData<HelloResponse> = response

    fun askHello() {
        viewModelScope.launch {

            val work1 = async {
                api.progress { progressValue ->
                    progress.postValue(progressValue)
                }
            }

            val work2 = async {
                api.hello("LevinK")
            }

            work1.await()
            response.value = work2.await()
        }
    }
}




















