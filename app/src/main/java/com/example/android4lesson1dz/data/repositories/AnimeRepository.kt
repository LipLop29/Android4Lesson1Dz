package com.example.android4lesson1dz.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.android4lesson1dz.data.repositories.pagingsources.AnimePagingSources
import com.example.android4lesson1dz.base.BaseRepository
import com.example.android4lesson1dz.data.remote.apiserveces.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService
) : BaseRepository(){

    fun fetchAnime() =
        Pager(
        PagingConfig(
            pageSize = 20,
            initialLoadSize = 10
        )
    ){
        AnimePagingSources(animeApiService)
    }.liveData

    fun fetchDetailAnime(id: String) = doRequest {
        animeApiService.fetchDetailAnime(id)
    }
}