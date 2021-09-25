package com.bertholucci.restaurants.presentation.ui.restaurant

import android.os.Bundle
import android.view.LayoutInflater
import com.bertholucci.restaurants.common.base.BaseFragment
import com.bertholucci.restaurants.databinding.FragmentRestaurantMenuBinding
import com.bertholucci.restaurants.presentation.model.MenuItem
import java.util.*

const val ARGS_MENU = "ARGS_MENU"

class RestaurantMenuFragment : BaseFragment<FragmentRestaurantMenuBinding>() {

    override fun getViewBinding() =
        FragmentRestaurantMenuBinding.inflate(LayoutInflater.from(context))

    companion object {
        fun newInstance(list: ArrayList<MenuItem>): RestaurantMenuFragment {
            val bundle = Bundle().apply { putParcelableArrayList(ARGS_MENU, list) }
            return RestaurantMenuFragment().apply { arguments = bundle }
        }
    }
}