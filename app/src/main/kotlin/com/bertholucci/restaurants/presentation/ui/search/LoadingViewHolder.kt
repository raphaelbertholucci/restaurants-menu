package com.bertholucci.restaurants.presentation.ui.search

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bertholucci.restaurants.databinding.ItemLoadingBinding

class LoadingViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private var binding = ItemLoadingBinding.bind(itemView)

    fun bind(isFullyLoaded: Boolean) {
        binding.loading.isVisible = isFullyLoaded.not()
        binding.tvFullyLoaded.isVisible = isFullyLoaded
    }
}