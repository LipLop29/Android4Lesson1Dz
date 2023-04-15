package com.example.android4lesson1dz.data.repositories.pagingsources

import android.net.Uri
import com.example.android4lesson1dz.base.BasePagingSource
import com.example.android4lesson1dz.data.remote.apiserveces.AnimeApiService
import com.example.android4lesson1dz.models.DataItem

private const val CHARACTER_STARTING_PAGE_INDEX = 1

class AnimePagingSources(private val animeApiService: AnimeApiService) :
    BasePagingSource<DataItem>(){

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        return try {
            val nextPage = params.key ?: CHARACTER_STARTING_PAGE_INDEX
            val response = animeApiService.fetchAnime(params.loadSize, nextPage)
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