package com.bertholucci.restaurants.data.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.data.model.GeoResponse
import com.bertholucci.restaurants.domain.model.GeoDomain

class GeoResponseMapper : BaseMapper<GeoResponse?, GeoDomain> {

    override fun mapFromDomain(domain: GeoDomain): GeoResponse {
        throw UnsupportedOperationException("Unsupported Operation")
    }

    override fun mapToDomain(model: GeoResponse?): GeoDomain {
        return GeoDomain(
            lat = model?.lat ?: 0.0,
            lon = model?.lon ?: 0.0
        )
    }
}