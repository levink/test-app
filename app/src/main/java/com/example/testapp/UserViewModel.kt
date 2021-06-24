package com.example.testapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(
    private val api: SkiMapInterface,
    private val prop: MutableLiveData<String> = MutableLiveData()
) : ViewModel() {

    fun getProp() : LiveData<String> = prop

    fun askHello() {
        viewModelScope.launch {
            val response = api.hello("LevinK")
            prop.value = response
        }
    }
}




















