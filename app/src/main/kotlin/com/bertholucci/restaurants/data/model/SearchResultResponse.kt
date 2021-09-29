package com.bertholucci.restaurants.data.model

import com.google.gson.annotations.SerializedName

data class SearchResultResponse(
    @SerializedName("total_results") val totalResults: Int? = 0,
    @SerializedName("page") val page: Int? = 1,
    @SerializedName("total_pages") val totalPages: Int? = 1,
    @SerializedName("more_pages") val morePages: Boolean = false,
    @SerializedName("data") val data: List<RestaurantResponse>? = emptyList(),
    @SerializedName("num_results") val numResults: Int? = 0
)