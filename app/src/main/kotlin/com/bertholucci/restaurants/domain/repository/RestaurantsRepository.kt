package com.bertholucci.restaurants.domain.repository

import com.bertholucci.restaurants.domain.model.RestaurantDomain
import com.bertholucci.restaurants.domain.model.SearchResultDomain
import kotlinx.coroutines.flow.Flow

interface RestaurantsRepository {
    fun getRestaurantById(id: Long): Flow<RestaurantDomain>
    fun searchRestaurants(query: String?, page: Int = 1): Flow<SearchResultDomain>
}