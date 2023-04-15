package com.example.android4lesson1dz.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
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
    }
}