package com.bertholucci.restaurants.presentation.ui.restaurant

import com.bertholucci.restaurants.BaseTest
import com.bertholucci.restaurants.common.Response
import com.bertholucci.restaurants.domain.interactor.GetRestaurantById
import com.bertholucci.restaurants.presentation.mapper.RestaurantMapper
import com.bertholucci.restaurants.restaurantMock
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class RestaurantViewModelTest : BaseTest<RestaurantViewModel>() {

    @RelaxedMockK
    private lateinit var restaurantById: GetRestaurantById

    override fun init() {
        interactor = RestaurantViewModel(restaurantById = restaurantById)
    }

    @Test
    fun getRestaurantById(): Unit = runBlockingTest {
        coEvery { restaurantById(any()) } returns flow {
            emit(restaurantMock)
        }

        interactor.getRestaurantById(1L)

        interactor.restaurant.observeForever {
            assertEquals(
                Response.Success(RestaurantMapper().mapFromDomain(restaurantMock)),
                it
            )
        }
    }
}