package com.example.stackoverflow.network

import com.example.stackoverflow.models.User
import okhttp3.Call
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {

    @GET("/dashboard")
    fun getDashboard(): String

//    @POST("user/register")
//    fun createUser(
//        @Body user: User?
//    ): Call<ResponseBody>
//
//    @POST("user/login")
//    fun checkUser(
//        @Body user: User?
//    ): Call<ResponseBody?>?
}