package com.example.User.data

import com.example.user_repositories.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val client = OkHttpClient.Builder()
    .addInterceptor { chain ->
        val newRequest = chain.request().newBuilder().addHeader(
            "Authorization", "Bearer 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"
        ).build()
        chain.proceed(newRequest)
    }
    .build()

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://api.github.com")
    .addConverterFactory(GsonConverterFactory.create())
    .build()