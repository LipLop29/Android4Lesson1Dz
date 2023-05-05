package com.example.android4lesson1dz.ui.fragments.home.anime.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1dz.R
import com.example.android4lesson1dz.base.BaseFragment
import com.example.android4lesson1dz.databinding.FragmentDetailAnimeBinding
import com.example.android4lesson1dz.extensions.setImage
import com.example.android4lesson1dz.extensions.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailAnimeFragment :
    BaseFragment<FragmentDetailAnimeBinding, AnimeDetailViewModel>(R.layout.fragment_detail_anime) {

    override val binding by viewBinding(FragmentDetailAnimeBinding::bind)
    override val viewModel: AnimeDetailViewModel by viewModels()
    private val args by navArgs<DetailAnimeFragmentArgs>()

    override fun setupSubscribes() = with(binding){
        viewModel.fetchDetailAnime(args.id).subscribe(
            onError = {
                toast(it)
            },
            onSuccess = { it ->
                it.data.let {
                    itemDetailImg.setImage(it.attributes.posterImage.original)
                    itemBigImg.setImage(it.attributes.posterImage.original)
                    detailNameAnime.text = it.attributes.titles.enJp
                    tvAnimeEpisodes.text = it.attributes.episodeCount.toString()
                    tvAnimeStatus.text = it.attributes.status
                    tvAnimePremiered.text = it.attributes.startDate
                    tvAnimeAgeRating.text = it.attributes.ageRatingGuide
                }
            }
        )
    }
}