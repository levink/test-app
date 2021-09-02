package com.example.daggertest

import android.app.Application
import android.content.Context

@Suppress("unused")
class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }
