package com.example.android4lesson1dz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android4lesson1dz.base.BaseDiffUtilItemCallback
import com.example.android4lesson1dz.databinding.ItemAnimeMangaBinding
import com.example.android4lesson1dz.extention.setImage
import com.example.android4lesson1dz.models.DataItem

class MangaAdapter :
    PagingDataAdapter<DataItem, MangaAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    class ViewHolder(private val binding: ItemAnimeMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: DataItem?) {
            binding.itemAnimeImage.setImage(item!!.attributes.posterImage.original)
            binding.itemNameTv.text = item.attributes.titles.enJp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimeMangaBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}