package com.example.User.di

import com.example.User.data.KEY
import com.example.User.data.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun providesHttpClient(): OkHttpClient{
    return OkHttpClient.Builder()
        .addInterceptor { chain ->
            val newRequest = chain.request().newBuilder().addHeader(
                "Authorization", "Bearer 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"
            ).build()
            chain.proceed(newRequest)
        }
        .build()}
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun providesUsersService(retrofit: Retrofit): UsersService {
        return retrofit.create(UsersService::class.java)
    }
}