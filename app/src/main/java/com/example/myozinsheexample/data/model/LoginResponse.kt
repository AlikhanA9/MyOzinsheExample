package com.example.myozinsheexample.data.model


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("id")
    val id: Int, // 25922
    @SerializedName("username")
    val username: String, // aliali@gmail.com
    @SerializedName("email")
    val email: String, // aliali@gmail.com
    @SerializedName("roles")
    val roles: List<String>,
    @SerializedName("accessToken")
    val accessToken: String, // eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhbGlhbGlAZ21haWwuY29tIiwiaWF0IjoxNzQ1MTQ1NjUyLCJleHAiOjE3NzY2ODE2NTJ9.AVgV971LS4BDeJ35QjawqtyMScTHemrmAkaXioJZnZ8Jr2gdbEHIqRASKPfWWA1U3Czh8EfsX9Tt0n1JlThdPQ
    @SerializedName("tokenType")
    val tokenType: String, // Bearer
    val message: String
)