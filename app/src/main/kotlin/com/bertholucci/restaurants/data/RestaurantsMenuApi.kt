package com.bertholucci.restaurants.data

import com.bertholucci.restaurants.data.model.RestaurantDataResponse
import com.bertholucci.restaurants.data.model.SearchResultResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RestaurantsMenuApi {
    @GET("restaurant/{restaurant_id}")
    suspend fun getRestaurantById(@Path("restaurant_id") id: Long): RestaurantDataResponse

    @GET("restaurants/search/fields")
    suspend fun searchRestaurants(
        @Query("restaurant_name") query: String?,
        @Query("page") page: Int
    ): SearchResultResponse
}