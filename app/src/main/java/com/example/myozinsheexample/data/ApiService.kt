package com.example.myozinsheexample.data

import com.example.myozinsheexample.data.model.LoginRequest
import com.example.myozinsheexample.data.model.LoginResponse
import com.example.myozinsheexample.data.model.MainMoviesResponse
import com.example.myozinsheexample.presentation.Login.LoginFragment
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @GET("/core/V1/movies_main")
    suspend fun getMainMovies(@Headers("Authorization") token: String): MainMoviesResponse
    @POST("auth/V1/signin")
    suspend fun loginUser(@Body loginRequest: LoginRequest): LoginResponse
}


