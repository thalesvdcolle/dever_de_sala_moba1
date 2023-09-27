package com.example.user_repositories.ui

import com.example.user_repositories.data.Repository
import com.google.gson.annotations.SerializedName

class SearchResponse {
    @SerializedName("Search") val repositories: List<Repository>
}