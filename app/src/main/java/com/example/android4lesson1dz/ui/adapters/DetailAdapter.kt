package com.example.android4lesson1dz.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android4lesson1dz.base.BaseDiffUtilItemCallback
import com.example.android4lesson1dz.databinding.ItemDetailBinding
import com.example.android4lesson1dz.models.DataItem

class DetailAdapter :
    PagingDataAdapter<DataItem, DetailAdapter.ViewHolder>(BaseDiffUtilItemCallback()) {

    inner class ViewHolder(private val binding: ItemDetailBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: DataItem?) {
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDetailBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }
}