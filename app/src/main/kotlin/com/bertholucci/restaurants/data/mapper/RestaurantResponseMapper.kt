package com.bertholucci.restaurants.data.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.data.model.RestaurantResponse
import com.bertholucci.restaurants.domain.model.RestaurantDomain

class RestaurantResponseMapper : BaseMapper<RestaurantResponse, RestaurantDomain> {

    override fun mapFromDomain(domain: RestaurantDomain): RestaurantResponse {
        throw UnsupportedOperationException("Unsupported Operation")
    }

    override fun mapToDomain(model: RestaurantResponse): RestaurantDomain {
        return RestaurantDomain(
            name = model.name ?: "",
            phone = model.phone ?: "",
            website = model.website ?: "",
            hours = model.hours ?: "",
            priceRange = model.priceRange ?: "",
            id = model.id ?: 0,
            cuisines = model.cuisines ?: emptyList(),
            address = AddressResponseMapper().mapToDomain(model.address),
            geo = GeoResponseMapper().mapToDomain(model.geo),
            menus = MenuResponseMapper().mapToDomain(model.menus),
            lastUpdated = model.lastUpdated ?: ""
        )
    }
}