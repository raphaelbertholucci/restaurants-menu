package com.bertholucci.restaurants.domain.repository

import com.bertholucci.restaurants.domain.model.RestaurantDomain
import kotlinx.coroutines.flow.Flow

interface RestaurantsRepository {
    fun getRestaurantById(id: Long): Flow<RestaurantDomain>
}