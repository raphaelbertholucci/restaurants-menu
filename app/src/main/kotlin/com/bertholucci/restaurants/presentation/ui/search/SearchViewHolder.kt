package com.bertholucci.restaurants.presentation.ui.search

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bertholucci.restaurants.common.extensions.addRipple
import com.bertholucci.restaurants.databinding.ItemRestaurantBinding
import com.bertholucci.restaurants.presentation.model.Restaurant

class SearchViewHolder internal constructor(
    itemView: View,
    val onClick: ((Long) -> Unit)? = null
) : RecyclerView.ViewHolder(itemView) {

    private var binding = ItemRestaurantBinding.bind(itemView)

    fun bind(item: Restaurant) {
        binding.tvTitle.text = item.name
        binding.tvPhone.text = item.phone
        binding.tvPhone.isVisible = item.phone.isNotEmpty()
        itemView.addRipple()
        itemView.setOnClickListener {
            onClick?.invoke(item.id)
        }
    }
}