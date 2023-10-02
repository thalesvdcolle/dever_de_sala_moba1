package com.example.User.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.User.data.UsersService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class UsersViewModel @Inject constructor(private val usersService: UsersService) : ViewModel() {
    private val _usersState = MutableStateFlow(UsersUiState())
    val usersUiState: StateFlow<UsersUiState>
        get() = _usersState

    init{
        searchUsers()
    }
    fun searchUsers() {
        viewModelScope.launch {
            try {
                val response = usersService.searchUsers("DanOninho")
                if (response.isSuccessful) {
                    Log.d("Usuários", "Busca bem-sucedida")
                    Log.d("Usuários", response.body().toString())
                    _usersState.update { currentState ->
                        currentState.copy(
                            users = response.body()?.userss ?: listOf()
                        )
                    }
                } else {
                    Log.e("Usuários", "Erro na solicitação: ${response.code()}")
                    _usersState.update { currentState ->
                        currentState.copy(
                            error = "Erro na solicitação"
                        )
                    }
                }
            } catch (e: Exception) {
                Log.e("Usuários", "Erro na rede: ${e.message}")
                _usersState.update { currentState ->
                    currentState.copy(
                        error = "Erro de rede: ${e.message}"
                    )
                }
            }
        }
    }
}