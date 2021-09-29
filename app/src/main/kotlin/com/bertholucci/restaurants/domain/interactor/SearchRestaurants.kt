package com.bertholucci.restaurants.domain.interactor

import com.bertholucci.restaurants.domain.UseCase
import com.bertholucci.restaurants.domain.model.SearchResultDomain
import com.bertholucci.restaurants.domain.repository.RestaurantsRepository
import kotlinx.coroutines.flow.Flow

class SearchRestaurants(private val repository: RestaurantsRepository) :
    UseCase<Pair<String?, Int>, SearchResultDomain>() {

    override fun executeUseCase(requestValues: Pair<String?, Int>): Flow<SearchResultDomain> {
        return repository.searchRestaurants(query = requestValues.first, page = requestValues.second)
    }
}