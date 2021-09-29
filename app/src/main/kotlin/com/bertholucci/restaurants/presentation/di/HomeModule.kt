package com.bertholucci.restaurants.presentation.di

import com.bertholucci.restaurants.presentation.ui.restaurant.RestaurantViewModel
import com.bertholucci.restaurants.presentation.ui.search.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { RestaurantViewModel(restaurantById = get()) }
    viewModel { SearchViewModel(searchRestaurants = get()) }
}