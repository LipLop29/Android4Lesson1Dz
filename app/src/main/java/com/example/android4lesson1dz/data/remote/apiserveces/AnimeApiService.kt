package com.example.android4lesson1dz.data.remote.apiserveces

import com.example.android4lesson1dz.models.DataItem
import com.example.android4lesson1dz.models.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(
        @Query("page[limit]") pageLimit: Int,
        @Query("page[offset]") pageOffset: Int
    ) : ResponseModel<DataItem>
}