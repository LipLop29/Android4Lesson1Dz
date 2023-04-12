package com.example.android4lesson1dz.ui.fragments.anime

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1dz.R
import com.example.android4lesson1dz.Resource
import com.example.android4lesson1dz.base.BaseFragment
import com.example.android4lesson1dz.databinding.FragmentAnimeBinding
import com.example.android4lesson1dz.ui.adapters.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AnimeFragment :
    BaseFragment<FragmentAnimeBinding, AnimeViewModel>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private var animeAdapter = AnimeAdapter()


    override fun initialize() {
        binding.recyclerAnime.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    override fun setupObserves() {
        super.setupObserves()
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT)
                        .show()
                }
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    it.data?.let {data->
                        animeAdapter.submitList(data.data)
                    }
                }
            }
        }
    }
}