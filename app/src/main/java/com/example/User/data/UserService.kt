package com.example.User.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersService {
    @GET("search/users")
    suspend fun searchUsers(@Query("q")searchQuery: String): Response<UserResponse>
}

val usersService = retrofit.create(UsersService::class.java)

val users = listOf(
    "DanOninho16",
    "Pedro",
    "GrandeOnde",
    "CorreaHugo",
)