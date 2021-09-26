package com.bertholucci.restaurants.data.repository

import com.bertholucci.restaurants.BaseTest
import com.bertholucci.restaurants.data.RestaurantsMenuApi
import com.bertholucci.restaurants.data.mapper.RestaurantResponseMapper
import com.bertholucci.restaurants.domain.repository.RestaurantsRepository
import com.bertholucci.restaurants.restaurantResponseMock
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class RestaurantRepositoryImplTest : BaseTest<RestaurantsRepository>() {

    @RelaxedMockK
    private lateinit var api: RestaurantsMenuApi

    override fun init() {
        interactor = RestaurantsRepositoryImpl(api)
    }

    @Test
    fun getRestaurantById() = runBlockingTest {
        coEvery { api.getRestaurantById(any()) } returns restaurantResponseMock

        interactor.getRestaurantById(1L).collect { result ->
            assertEquals(
                RestaurantResponseMapper().mapToDomain(restaurantResponseMock.result),
                result
            )
        }
    }
}