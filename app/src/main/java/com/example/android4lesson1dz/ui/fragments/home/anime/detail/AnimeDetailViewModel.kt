package com.example.android4lesson1dz.ui.fragments.home.anime.detail

import com.example.android4lesson1dz.base.BaseViewModel
import com.example.android4lesson1dz.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
private var animeRepository: AnimeRepository
) : BaseViewModel() {

    fun fetchDetailAnime(id: String) = animeRepository.fetchDetailAnime(id)
}