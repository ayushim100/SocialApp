package com.example.stackoverflow.network

import androidx.lifecycle.Observer
import com.example.stackoverflow.models.User
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ServerCallManager {
    private val BASE_URL = "http://localhost:8082"
    private val mRetrofit: Retrofit
    private val apiService: APIService

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(
                RxJavaCallAdapterFactory.create()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        apiService = mRetrofit.create(APIService::class.java)
    }

    fun createUser(user: User) {
        apiService.createUser(user)
    }
}