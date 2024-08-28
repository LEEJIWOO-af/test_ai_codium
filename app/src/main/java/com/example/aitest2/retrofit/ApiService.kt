package com.example.aitest2.retrofit

import com.example.aitest2.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}