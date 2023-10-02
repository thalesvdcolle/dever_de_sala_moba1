package com.example.User.ui

import com.example.User.data.User

data class UsersUiState (
    val users: List<User> = listOf(),
    val error: String? = null
)