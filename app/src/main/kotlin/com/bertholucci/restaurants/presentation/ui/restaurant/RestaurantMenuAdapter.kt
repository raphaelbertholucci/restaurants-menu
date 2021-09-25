package com.bertholucci.restaurants.presentation.ui.restaurant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bertholucci.restaurants.R
import com.bertholucci.restaurants.presentation.model.MenuItem

class RestaurantMenuAdapter(private val list: List<MenuItem>) :
    RecyclerView.Adapter<RestaurantMenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantMenuViewHolder {
        return RestaurantMenuViewHolder(
            itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_menu, parent, false)
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RestaurantMenuViewHolder, position: Int) {
        holder.bind(list[position])
    }
}