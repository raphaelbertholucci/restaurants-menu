package com.bertholucci.restaurants.presentation.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bertholucci.restaurants.R
import com.bertholucci.restaurants.presentation.model.Restaurant

class SearchAdapter(private val list: MutableList<Restaurant> = mutableListOf()) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onClick: ((Long) -> Unit)? = null

    var isLoading = false
    var isFullyLoaded = false
    private val viewTypeItem = 0
    private val viewTypeLoading = 1

    fun updateList(restaurantList: List<Restaurant>) {
        list.addAll(restaurantList)
        notifyDataSetChanged()
    }

    fun setList(restaurantList: List<Restaurant>) {
        list.clear()
        list.addAll(restaurantList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        if (viewType == viewTypeItem) {
            SearchViewHolder(
                itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_restaurant, parent, false),
                onClick = onClick
            )
        } else {
            LoadingViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_loading, parent, false)
            )
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SearchViewHolder) {
            holder.bind(list[position])
        } else if (holder is LoadingViewHolder) {
            holder.bind(isFullyLoaded)
        }
    }

    override fun getItemCount(): Int =
        if (list.isNotEmpty()) list.size + 1
        else 0

    override fun getItemViewType(position: Int): Int {
        return if (position == list.size) viewTypeLoading else viewTypeItem
    }

    override fun getItemId(position: Int): Long {
        return if (getItemViewType(position) == viewTypeItem) position.toLong()
        else -1
    }
}