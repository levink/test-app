package com.example.testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.skimap.api.SkiMapInterface
import com.example.testapp.skimap.model.HelloResponse
import kotlinx.coroutines.launch

class UserViewModel(
    private val api: SkiMapInterface,
    private val response: MutableLiveData<HelloResponse> = MutableLiveData()
) : ViewModel() {

    fun getResponse() : LiveData<HelloResponse> = response

    fun askHello() {
        viewModelScope.launch {
            val value = api.hello("LevinK")
            response.value = value
        }
    }
}




















