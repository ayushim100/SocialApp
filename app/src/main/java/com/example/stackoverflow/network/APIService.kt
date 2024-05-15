package com.example.stackoverflow.network

import com.example.stackoverflow.models.User
import retrofit2.Response
import rx.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface APIService {

    @GET("/dashboard")
    fun getDashboard(): String

    @POST("/user")
    fun createUser(@Body user: User): Observable<Response<String>>

}