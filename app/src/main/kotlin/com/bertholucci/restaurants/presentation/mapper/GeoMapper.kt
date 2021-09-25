package com.bertholucci.restaurants.presentation.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.domain.model.GeoDomain
import com.bertholucci.restaurants.presentation.model.Geo

class GeoMapper : BaseMapper<Geo, GeoDomain> {

    override fun mapFromDomain(domain: GeoDomain): Geo {
        return Geo(
            lat = domain.lat,
            lon = domain.lon
        )
    }

    override fun mapToDomain(model: Geo): GeoDomain {
        throw UnsupportedOperationException("Unsupported Operation")
    }
}