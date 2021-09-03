package com.example.daggertest

import javax.inject.Inject

class DBHelper @Inject constructor() {
    fun getStudent(id: Long): Student {
        return Student(
            id = id,
            name = "student with id=$id"
        )
    }
}