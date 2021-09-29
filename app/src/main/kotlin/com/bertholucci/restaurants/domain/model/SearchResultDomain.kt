package com.bertholucci.restaurants.domain.model

class SearchResultDomain(
    val totalResults: Int? = 0,
    val page: Int? = 1,
    val totalPages: Int? = 1,
    val morePages: Boolean = false,
    val data: List<RestaurantDomain>? = emptyList(),
    val numResults: Int? = 0
)