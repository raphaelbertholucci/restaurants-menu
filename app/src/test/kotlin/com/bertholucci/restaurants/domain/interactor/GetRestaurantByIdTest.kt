package com.bertholucci.restaurants.domain.interactor

import com.bertholucci.restaurants.BaseTest
import com.bertholucci.restaurants.domain.repository.RestaurantsRepository
import com.bertholucci.restaurants.restaurantMock
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Test

@ExperimentalCoroutinesApi
class GetRestaurantByIdTest : BaseTest<GetRestaurantById>() {

    @RelaxedMockK
    private lateinit var repository: RestaurantsRepository

    override fun init() {
        interactor = GetRestaurantById(repository)
    }

    @Test
    fun addCounter() = runBlockingTest {
        coEvery { repository.getRestaurantById(any()) } returns flow {
            emit(restaurantMock)
        }

        interactor(1L)

        interactor.invoke(1L).collect { result ->
            Assert.assertEquals(restaurantMock, result)
        }
    }
}