package com.example.android4lesson1dz.data.remote.apiserveces

import com.example.android4lesson1dz.models.DataItem
import com.example.android4lesson1dz.models.ResponseModel
import retrofit2.http.GET

interface MangaApiService {

    @GET("manga?page[limit]=20&page[offset]=28")
    suspend fun fetchManga() : ResponseModel<DataItem>
}