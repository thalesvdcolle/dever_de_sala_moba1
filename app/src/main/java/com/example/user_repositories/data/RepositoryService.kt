package com.example.user_repositories.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RepositoriesService {
    @GET("/users/{user}/repos;")
    fun searchRepositories(@Query("{user}")searchQuery: String): Response<SearchResponse>
}

val repositoriesService = retrofit.create(RepositoriesService::class.java)!!

val repositories = listOf(
    "DanOninho16",
    "Pedro",
    "GrandeOnde",
    "CorreaHugo",
)