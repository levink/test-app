package com.example.daggertest

import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(fragment: FirstFragment)
}

@Module
object AppModule