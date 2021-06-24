package com.example.testapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

class UserViewModel(
    private val api: SkiMapInterface,
    private val prop: MutableLiveData<String> = MutableLiveData()
) : ViewModel() {

    fun getProp() : LiveData<String> = prop

    fun sayHello() {
        val channel = Channel<String>()

        viewModelScope.launch {
            val response = hello2("LevinK")
            prop.value = response
            channel.send(response)
        }

        viewModelScope.launch {
            val value = channel.receive()
           // Log.d("test123", "response receive: $value")
        }
    }

    private suspend fun hello1(username: String): String {
        return withContext(Dispatchers.IO) {
            val response = api.hello(username)
            response.message
        }
    }

    private suspend fun hello2(username: String) : String {
        return withContext(Dispatchers.IO) {
            val client = HttpClient(CIO)
            client.use {
                val url = "https://snowrider.pro:1305/skimap/Hello"
                val response: HttpResponse = it.get(url){
                    parameter("username", username)
                }
                response.receive()
            }
        }
    }

}




















