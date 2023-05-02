package com.example.android4lesson1dz.ui.fragments.manga.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1dz.R
import com.example.android4lesson1dz.base.BaseFragment
import com.example.android4lesson1dz.databinding.FragmentMangaDetailBinding
import com.example.android4lesson1dz.extensions.setImage
import com.example.android4lesson1dz.extensions.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment :
    BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(R.layout.fragment_manga_detail) {

    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    override val viewModel: MangaDetailViewModel by viewModels()
    private val args by navArgs<MangaDetailFragmentArgs>()

    override fun setupSubscribes() = with(binding){
        viewModel.fetchDetailManga(args.id).subscribe(
            onError = {
                toast(it)
            },
            onSuccess = { it ->
                it.data.let {
                    itemDetailImg.setImage(it.attributes.posterImage.original)
                    itemBigImg.setImage(it.attributes.posterImage.original)
                    detailNameAnime.text = it.attributes.titles.enJp
                }
            }
        )
    }
}