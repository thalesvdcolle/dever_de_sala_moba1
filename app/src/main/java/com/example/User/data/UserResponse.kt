package com.example.User.data

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("items") val userss: List<User>
)
