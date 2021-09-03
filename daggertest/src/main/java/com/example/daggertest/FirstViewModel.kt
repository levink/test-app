package com.example.daggertest

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class FirstViewModel : ViewModel() {



//
//    class Factory (
//        private val db: DBHelper
//    ) : ViewModelProvider.Factory{
//
//        @Suppress("UNCHECKED_CAST")
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            if (modelClass == FirstViewModel::class.java) {
//                return FirstViewModel(db) as T
//            }
//            throw IllegalArgumentException("Bad ViewModel class")
//        }
//
//    }
}