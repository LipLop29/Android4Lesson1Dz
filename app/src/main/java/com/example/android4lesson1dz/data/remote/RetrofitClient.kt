package com.example.android4lesson1dz.data.remote

import com.example.android4lesson1dz.data.remote.apiserveces.AnimeApiService
import com.example.android4lesson1dz.data.remote.apiserveces.MangaApiService
import com.example.android4lesson1dz.data.remote.apiserveces.SignInApiService
import com.example.android4lesson1dz.data.repositories.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private var OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(TokenInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://kitsu.io/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient)
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideAnimeApiService() = retrofitClient.create(AnimeApiService::class.java)

    fun provideMangaApiService() = retrofitClient.create(MangaApiService::class.java)

    fun providerSignInApiService() = retrofitClient.create(SignInApiService::class.java)

}