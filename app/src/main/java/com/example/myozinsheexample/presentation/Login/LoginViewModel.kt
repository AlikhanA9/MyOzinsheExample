package com.example.myozinsheexample.presentation.Login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation.findNavController
import com.example.myozinsheexample.R
import com.example.myozinsheexample.data.ApiService
import com.example.myozinsheexample.data.ServiceBuilder
import com.example.myozinsheexample.data.model.LoginRequest
import com.example.myozinsheexample.data.model.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _loginResponse = MutableLiveData<LoginResponse>()
    val loginResponse: LiveData<LoginResponse> = _loginResponse

    private val _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String> = _errorResponse

    fun loginUser(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val apiService = ServiceBuilder.buildService(ApiService::class.java)
            runCatching {
                apiService.loginUser(LoginRequest(email, password))
            }.onSuccess {
                _loginResponse.postValue(it)
            }.onFailure {
                Log.e("LoginViewModel", "Login failed", it)
                _errorResponse.postValue(it.message)
            }
        }
    }
}

