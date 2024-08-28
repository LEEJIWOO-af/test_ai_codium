package com.example.aitest2.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aitest2.model.User
import com.example.aitest2.retrofit.RetrofitClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val apiService = RetrofitClient.apiService

    fun getUsers(): Flow<List<User>> {
        return flow {
            val users = apiService.getUsers()
            emit(users)
        }.catch { e ->
            // Handle error
        }
    }
}