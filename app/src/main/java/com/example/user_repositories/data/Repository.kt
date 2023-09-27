package com.example.user_repositories.data

import com.google.gson.annotations.SerializedName

data class Repository(
   @SerializedName("Name") val name: String,
   @SerializedName("Description") val description: String,
)