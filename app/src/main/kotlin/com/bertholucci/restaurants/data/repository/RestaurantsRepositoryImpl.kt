package com.bertholucci.restaurants.data.repository

import com.bertholucci.restaurants.BuildConfig
import com.bertholucci.restaurants.data.RestaurantsMenuApi
import com.bertholucci.restaurants.data.mapper.RestaurantResponseMapper
import com.bertholucci.restaurants.data.mapper.SearchResultResponseMapper
import com.bertholucci.restaurants.domain.model.RestaurantDomain
import com.bertholucci.restaurants.domain.model.SearchResultDomain
import com.bertholucci.restaurants.domain.repository.RestaurantsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RestaurantsRepositoryImpl(private val api: RestaurantsMenuApi) : RestaurantsRepository {

    override fun getRestaurantById(id: Long): Flow<RestaurantDomain> {
        return flow {
            if (BuildConfig.DEBUG) delay(1000)
            emit(RestaurantResponseMapper().mapToDomain(api.getRestaurantById(id).result))
        }
    }

    override fun searchRestaurants(query: String?, page: Int): Flow<SearchResultDomain> {
        return flow {
            if (BuildConfig.DEBUG) delay(1000)
            emit(SearchResultResponseMapper().mapToDomain(api.searchRestaurants(query, page)))
        }
    }
}