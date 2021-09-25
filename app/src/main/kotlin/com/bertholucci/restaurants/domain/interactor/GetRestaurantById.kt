package com.bertholucci.restaurants.domain.interactor

import com.bertholucci.restaurants.domain.UseCase
import com.bertholucci.restaurants.domain.model.RestaurantDomain
import com.bertholucci.restaurants.domain.repository.RestaurantsRepository
import kotlinx.coroutines.flow.Flow

class GetRestaurantById(private val repository: RestaurantsRepository) :
    UseCase<Long, RestaurantDomain>() {
    override fun executeUseCase(requestValues: Long): Flow<RestaurantDomain> {
        return repository.getRestaurantById(requestValues)
    }
}