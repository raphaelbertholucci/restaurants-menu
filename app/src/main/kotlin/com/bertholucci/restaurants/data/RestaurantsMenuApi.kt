package com.bertholucci.restaurants.data

import com.bertholucci.restaurants.data.model.RestaurantDataResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RestaurantsMenuApi {
    @GET("restaurant/{restaurant_id}")
    suspend fun getRestaurantById(@Path("restaurant_id") id: Long): RestaurantDataResponse
}