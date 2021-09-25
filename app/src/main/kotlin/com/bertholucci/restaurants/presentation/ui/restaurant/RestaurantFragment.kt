package com.bertholucci.restaurants.presentation.ui.restaurant

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import com.bertholucci.restaurants.R
import com.bertholucci.restaurants.common.base.BaseFragment
import com.bertholucci.restaurants.common.fold
import com.bertholucci.restaurants.databinding.FragmentRestaurantBinding
import com.bertholucci.restaurants.presentation.extensions.showSnack
import com.bertholucci.restaurants.presentation.extensions.toArrayList
import com.bertholucci.restaurants.presentation.model.Menu
import com.bertholucci.restaurants.presentation.model.Restaurant
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class RestaurantFragment : BaseFragment<FragmentRestaurantBinding>() {

    private val viewModel: RestaurantViewModel by viewModel()

    override fun getViewBinding() = FragmentRestaurantBinding.inflate(LayoutInflater.from(context))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObservers()

        viewModel.getRestaurantById(4072702673999819)
    }

    private fun addObservers() {
        viewModel.restaurant.observe(viewLifecycleOwner) { response ->
            response.fold(::handleError, ::handleSuccess)
        }
    }

    private fun handleSuccess(restaurant: Restaurant) {
        binding.tvName.text = restaurant.name
        binding.vpMenu.adapter = RestaurantTabAdapter(
            childFragmentManager,
            lifecycle,
            getFragmentsList(restaurant.menus.first())
        )
        TabLayoutMediator(binding.tabMenu, binding.vpMenu) { tab, position ->
            tab.text = restaurant.menus.first().sections[position].name
        }.attach()
    }

    private fun getFragmentsList(menu: Menu): List<Fragment> {
        val list = mutableListOf<Fragment>()
        menu.sections.forEach {
            list.add(RestaurantMenuFragment.newInstance(it.items.toArrayList()))
        }
        return list
    }

    private fun handleError(throwable: Throwable) {
        Log.d("ERROR", throwable.message.toString())
        showSnack(R.string.generic_error)
    }
}