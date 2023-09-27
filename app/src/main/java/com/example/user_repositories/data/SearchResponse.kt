package com.example.user_repositories.data

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("Search") val repositories: List<Repository>
)
