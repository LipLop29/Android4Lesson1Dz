package com.example.android4lesson1dz.data.remote.apiserveces

import com.example.android4lesson1dz.models.DataItem
import com.example.android4lesson1dz.models.ResMod
import com.example.android4lesson1dz.models.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("edge/manga")
    suspend fun fetchManga(
        @Query("page[limit]") pageLimit: Int,
        @Query("page[offset]") pageOffset: Int
    ) : ResponseModel<DataItem>

    @GET("edge/manga/{id}")
    suspend fun fetchDetailManga(
        @Path("id") id : String
    ) : ResMod
}