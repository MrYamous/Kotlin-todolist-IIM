package com.example.todokotlin.data.network

import com.example.todokotlin.data.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("login")
        fun login(
        @Query("email") email: String,
        @Query("pwd") pwd: String
    ): Call<ApiResponse>
}