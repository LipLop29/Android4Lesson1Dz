package com.example.android4lesson1dz.ui.fragments.home.manga.detail

import com.example.android4lesson1dz.base.BaseViewModel
import com.example.android4lesson1dz.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(
    private var mangaRepository: MangaRepository
    ) : BaseViewModel() {

    fun fetchDetailManga(id: String) = mangaRepository.fetchDetailManga(id)
}