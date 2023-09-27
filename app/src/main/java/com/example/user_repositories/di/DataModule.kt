package com.example.user_repositories.di

import com.example.user_repositories.data.RepositoriesService
import com.example.user_repositories.data.repositoriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {
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