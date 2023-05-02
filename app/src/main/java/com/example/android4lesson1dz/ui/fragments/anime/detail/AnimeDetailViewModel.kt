package com.example.android4lesson1dz.ui.fragments.anime.detail

import androidx.lifecycle.LiveData
import com.example.android4lesson1dz.utils.Resource
import com.example.android4lesson1dz.base.BaseViewModel
import com.example.android4lesson1dz.data.repositories.AnimeRepository
import com.example.android4lesson1dz.models.ResMod
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
private var animeRepository: AnimeRepository
) : BaseViewModel() {

    fun fetchDetailAnime(id: String) = animeRepository.fetchDetailAnime(id)
}