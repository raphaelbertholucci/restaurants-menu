package com.bertholucci.restaurants.data.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.data.model.SearchResultResponse
import com.bertholucci.restaurants.domain.model.SearchResultDomain

class SearchResultResponseMapper : BaseMapper<SearchResultResponse, SearchResultDomain> {

    override fun mapFromDomain(domain: SearchResultDomain): SearchResultResponse {
        throw UnsupportedOperationException("Unsupported Operation")
    }

    override fun mapToDomain(model: SearchResultResponse): SearchResultDomain {
        return SearchResultDomain(
            totalPages = model.totalPages,
            totalResults = model.totalResults,
            page = model.page,
            morePages = model.morePages,
            data = RestaurantResponseMapper().mapToDomainList(model.data),
            numResults = model.numResults
        )
    }
}