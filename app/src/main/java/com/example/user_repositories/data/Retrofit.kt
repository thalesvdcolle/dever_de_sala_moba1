package com.example.user_repositories.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val client = OkHttpClient.Builder()
    .addInterceptor { chain ->
        val newRequest = chain.request().newBuilder().addHeader(
            "Autorization: Bearer ", "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"
        ).build()
        chain.proceed(newRequest)
    }
    .build()

val retrofit = Retrofit.Builder()
    .baseUrl("https://https://api.github.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()