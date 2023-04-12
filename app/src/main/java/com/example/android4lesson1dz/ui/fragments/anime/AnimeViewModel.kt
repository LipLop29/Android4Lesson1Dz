package com.example.android4lesson1dz.ui.fragments.anime

import androidx.lifecycle.ViewModel
import com.example.android4lesson1dz.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private var animeRepository : AnimeRepository
) : ViewModel() {

    fun fetchAnime() = animeRepository.fetchAnime()
}