package com.example.android4lesson1dz.data.repositories.pagingsources

import android.net.Uri
import com.example.android4lesson1dz.base.BasePagingSource
import com.example.android4lesson1dz.data.remote.apiserveces.MangaApiService
import com.example.android4lesson1dz.models.DataItem

private const val MANGA_STARTING_PAGE_INDEX = 1

class MangaPagingSources(private val mangaApiService: MangaApiService) :
    BasePagingSource<DataItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        return try {
            val nextPage = params.key ?: MANGA_STARTING_PAGE_INDEX
            val response = mangaApiService.fetchManga(params.loadSize, nextPage)
            val nextPages =
                Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()

            LoadResult.Page(
                data = response.data,
                prevKey = if (nextPage == 1) null
                else nextPage - 1,
                nextKey = nextPages
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}