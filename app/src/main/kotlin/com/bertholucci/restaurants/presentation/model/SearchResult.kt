package com.bertholucci.restaurants.presentation.model

class SearchResult(
    val totalResults: Int? = 0,
    val page: Int? = 1,
    val totalPages: Int? = 1,
    val morePages: Boolean = false,
    val data: List<Restaurant> = emptyList(),
    val numResults: Int? = 0
)