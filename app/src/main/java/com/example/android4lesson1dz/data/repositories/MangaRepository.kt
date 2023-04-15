package com.example.android4lesson1dz.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.android4lesson1dz.data.repositories.pagingsources.MangaPagingSources
import com.example.android4lesson1dz.base.BaseRepository
import com.example.android4lesson1dz.data.remote.apiserveces.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiService: MangaApiService
) : BaseRepository() {

    fun fetchManga() = Pager(
        PagingConfig(
            pageSize = 20,
            initialLoadSize = 10
        ),
        pagingSourceFactory = {
            MangaPagingSources(mangaApiService)
        })
}