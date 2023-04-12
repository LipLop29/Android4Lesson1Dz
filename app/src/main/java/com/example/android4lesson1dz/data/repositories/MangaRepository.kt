package com.example.android4lesson1dz.data.repositories

import androidx.lifecycle.liveData
import com.example.android4lesson1dz.Resource
import com.example.android4lesson1dz.data.remote.apiserveces.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiService: MangaApiService
) {

    fun fetchManga() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(mangaApiService.fetchManga()))
        }catch (exception : Exception){
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
}