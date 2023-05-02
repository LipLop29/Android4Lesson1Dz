package com.example.android4lesson1dz.di

import com.example.android4lesson1dz.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    private val retrofit = RetrofitClient()

    @Singleton
    @Provides
    fun provideAnimeApiService() = retrofit.provideAnimeApiService()

    @Singleton
    @Provides
    fun provideMangaApiService() = retrofit.provideMangaApiService()

    @Singleton
    @Provides
    fun provideSignInApiService() = retrofit.providerSignInApiService()
}