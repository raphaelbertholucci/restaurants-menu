package com.bertholucci.restaurants.presentation.ui.restaurant

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bertholucci.restaurants.common.base.BaseFragment
import com.bertholucci.restaurants.common.fold
import com.bertholucci.restaurants.databinding.FragmentRestaurantBinding
import com.bertholucci.restaurants.presentation.extensions.toArrayList
import com.bertholucci.restaurants.presentation.model.Menu
import com.bertholucci.restaurants.presentation.model.Restaurant
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class RestaurantFragment : BaseFragment<FragmentRestaurantBinding>() {

    private val viewModel: RestaurantViewModel by viewModel()

    override fun getViewBinding() = FragmentRestaurantBinding.inflate(LayoutInflater.from(context))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObservers()
        addListeners()

        viewModel.getRestaurantById(4072702673999819)
    }

    private fun addObservers() {
        viewModel.restaurant.observe(viewLifecycleOwner) { response ->
            response.fold(::handleError, ::handleSuccess)
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            display(loading = it)
        }
    }

    private fun addListeners() {
        binding.btnRetry.setOnClickListener { viewModel.getRestaurantById(4072702673999819) }
    }

    private fun handleSuccess(restaurant: Restaurant) {
        binding.tvName.text = restaurant.name
        binding.vpMenu.adapter = RestaurantTabAdapter(
            childFragmentManager,
            lifecycle,
            getFragmentsList(restaurant.menus.first())
        )
        setupTabLayout(restaurant)
        display(content = true)
    }

    private fun setupTabLayout(restaurant: Restaurant) {
        TabLayoutMediator(binding.tabMenu, binding.vpMenu) { tab, position ->
            tab.text = restaurant.menus.first().sections[position].name
        }.attach()
        binding.tabMenu.tabGravity = TabLayout.GRAVITY_FILL
        binding.tabMenu.tabMode = TabLayout.MODE_SCROLLABLE
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
        display(error = true)
    }

    private fun display(
        content: Boolean = false,
        loading: Boolean = false,
        error: Boolean = false
    ) {
        binding.group.isVisible = content
        binding.progress.isVisible = loading
        binding.tvError.isVisible = error
        binding.btnRetry.isVisible = error
    }
}