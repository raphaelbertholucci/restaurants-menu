package com.bertholucci.restaurants.presentation.ui.restaurant

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bertholucci.restaurants.R
import com.bertholucci.restaurants.common.helpers.WITHOUT_PRICE
import com.bertholucci.restaurants.databinding.ItemMenuBinding
import com.bertholucci.restaurants.presentation.model.MenuItem

class RestaurantMenuViewHolder internal constructor(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private var binding = ItemMenuBinding.bind(itemView)

    fun bind(item: MenuItem) {
        binding.tvTitle.text = item.name
        binding.tvDescription.text = item.description
        binding.tvDescription.isVisible = item.description.isNotEmpty()

        val price = item.pricing.first().priceString
        binding.tvPrice.text = getPrice(price)
    }

    private fun getPrice(price: String) =
        if (price == WITHOUT_PRICE) itemView.resources.getString(R.string.consult_price)
        else price
}