package com.example.android4lesson1dz.ui.fragments.manga.detail

import androidx.lifecycle.LiveData
import com.example.android4lesson1dz.utils.Resource
import com.example.android4lesson1dz.base.BaseViewModel
import com.example.android4lesson1dz.data.repositories.MangaRepository
import com.example.android4lesson1dz.models.ResMod
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaDetailViewModel @Inject constructor(
    private var mangaRepository: MangaRepository
    ) : BaseViewModel() {

    fun fetchDetailManga(id: String) = mangaRepository.fetchDetailManga(id)
}