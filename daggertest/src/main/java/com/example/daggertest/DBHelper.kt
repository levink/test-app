package com.example.daggertest

class DBHelper {
    fun getStudent(): Student {
        return Student(
            id = 100500,
            name = "test name"
        )
    }
}