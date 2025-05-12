package com.example.myozinsheexample.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myozinsheexample.data.ApiService
import com.example.myozinsheexample.data.ServiceBuilder
import com.example.myozinsheexample.data.model.LoginRequest
import com.example.myozinsheexample.data.model.LoginResponse
import com.example.myozinsheexample.data.model.MainMoviesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragmentViewModel: ViewModel() {
    private val _mainMoviesResponse = MutableLiveData<MainMoviesResponse>()
    val mainMoviesResponse: LiveData<MainMoviesResponse> = _mainMoviesResponse

    private val _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String> = _errorResponse

    fun getMainMoives(token:String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response= ServiceBuilder.buildService(ApiService::class.java)
            runCatching {response.getMainMovies("Bearer $token")
            }.onSuccess {
                _mainMoviesResponse.postValue(it)
            }.onFailure {
                _errorResponse.postValue(it.message)
            }
        }
    }
}