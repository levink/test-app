package com.example.testapp

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SkiMapService {
    companion object {
        private const val BASE_URL = "https://snowrider.pro:1305/skimap/"
        fun getInstance() : SkiMapInterface {
            val builder = GsonBuilder().create()
            val factory = GsonConverterFactory.create(builder)
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(factory)
                .build()
            return retrofit.create(SkiMapInterface::class.java)
        }

    }
}