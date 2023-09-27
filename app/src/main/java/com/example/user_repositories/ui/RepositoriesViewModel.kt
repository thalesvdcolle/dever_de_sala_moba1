package com.example.user_repositories.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.user_repositories.data.RepositoriesService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(private val repositoriesService: RepositoriesService) : ViewModel() {
    private val _repositoriesState = MutableStateFlow(RepositoriesUiState())
    val repositoriesUiState: StateFlow<RepositoriesUiState>
        get() = _repositoriesState

    init{
        searchRepositories()
    }
    fun searchRepositories() {
        viewModelScope.launch {
            val response = repositoriesService.searchRepositories("DanOninho16")
            if (response.isSuccessful) {
                _repositoriesState.update { currentState ->
                    currentState.copy(
                        repositories = response.body()?.repositories ?: listOf()
                    )
                }
            }
        }
    }
}