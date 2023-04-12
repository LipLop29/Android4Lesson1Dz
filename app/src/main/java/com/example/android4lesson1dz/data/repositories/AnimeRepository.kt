package com.example.android4lesson1dz.data.repositories

import androidx.lifecycle.liveData
import com.example.android4lesson1dz.Resource
import com.example.android4lesson1dz.data.remote.apiserveces.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService
) {

    fun fetchAnime() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(animeApiService.fetchAnime()))
        }catch (exception : Exception){
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
}