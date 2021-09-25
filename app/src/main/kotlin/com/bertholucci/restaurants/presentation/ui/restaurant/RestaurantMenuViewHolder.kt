package com.bertholucci.restaurants.presentation.ui.restaurant

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bertholucci.restaurants.databinding.ItemMenuBinding
import com.bertholucci.restaurants.presentation.model.MenuItem

class RestaurantMenuViewHolder internal constructor(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private var binding = ItemMenuBinding.bind(itemView)

    fun bind(item: MenuItem) {
        binding.tvTitle.text = item.name
        binding.tvDescription.text = item.description
        binding.tvDescription.isVisible = item.description.isNotEmpty()
        binding.tvPrice.text = item.pricing.first().priceString
    }
}