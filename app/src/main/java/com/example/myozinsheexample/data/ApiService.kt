package com.example.myozinsheexample.data

import com.example.myozinsheexample.data.model.LoginRequest
import com.example.myozinsheexample.data.model.LoginResponse
import com.example.myozinsheexample.presentation.Login.LoginFragment
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("auth/V1/signin")
    suspend fun loginUser(@Body loginRequest: LoginRequest): LoginResponse
}