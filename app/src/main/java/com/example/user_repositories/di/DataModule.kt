package com.example.user_repositories.di

import com.example.user_repositories.data.RepositoriesService
import com.example.user_repositories.data.repositoriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun providesClient(client: OkHttpClient): OkHttpClient {
            val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder().addHeader(
                    "Autorization: Bearer ", "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"
                ).build()
                chain.proceed(newRequest)
            }
            .build()
        return OkHttpClient()
    }
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun providesRepositoriesService(retrofit: Retrofit): RepositoriesService {
        return retrofit.create(repositoriesService::class.java)
    }
}