package com.example.stackoverflow.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerCallManager {
    private val BASE_URL = "http://localhost:8082"
    private val mRetrofit: Retrofit

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}