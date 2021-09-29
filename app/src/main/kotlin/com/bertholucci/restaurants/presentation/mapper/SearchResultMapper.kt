package com.bertholucci.restaurants.presentation.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.domain.model.SearchResultDomain
import com.bertholucci.restaurants.presentation.model.SearchResult

class SearchResultMapper : BaseMapper<SearchResult, SearchResultDomain> {

    override fun mapFromDomain(domain: SearchResultDomain): SearchResult {
        return SearchResult(
            totalPages = domain.totalPages,
            totalResults = domain.totalResults,
            page = domain.page,
            morePages = domain.morePages,
            data = RestaurantMapper().mapFromDomainList(domain.data),
            numResults = domain.numResults
        )
    }

    override fun mapToDomain(model: SearchResult): SearchResultDomain {
        throw UnsupportedOperationException("Unsupported Operation")
    }
}