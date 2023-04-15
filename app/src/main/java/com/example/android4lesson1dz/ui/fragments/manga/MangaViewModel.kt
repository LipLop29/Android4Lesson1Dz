package com.example.android4lesson1dz.ui.fragments.manga

import androidx.paging.liveData
import com.example.android4lesson1dz.base.BaseViewModel
import com.example.android4lesson1dz.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
private var mangaRepository : MangaRepository
) : BaseViewModel() {

    fun fetchManga() = mangaRepository.fetchManga().liveData
}