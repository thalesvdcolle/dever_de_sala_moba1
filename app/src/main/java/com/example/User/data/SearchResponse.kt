package com.example.User.data

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("Search") val users: UserResponse
)