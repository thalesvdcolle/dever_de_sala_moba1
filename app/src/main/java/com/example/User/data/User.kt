package com.example.User.data

import com.google.gson.annotations.SerializedName

data class User(
   @SerializedName("login") val name: String,
   @SerializedName("html_url") val url: String,
   @SerializedName("avatar_url") val avatar: String
)