package com.bertholucci.restaurants.presentation.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.domain.model.RestaurantDomain
import com.bertholucci.restaurants.presentation.model.Restaurant

class RestaurantMapper : BaseMapper<Restaurant, RestaurantDomain> {

    override fun mapFromDomain(domain: RestaurantDomain): Restaurant {
        return Restaurant(
            name = domain.name,
            phone = domain.phone,
            website = domain.website,
            hours = domain.hours,
            priceRange = domain.priceRange,
            id = domain.id,
            cuisines = domain.cuisines,
            address = AddressMapper().mapFromDomain(domain.address),
            geo = GeoMapper().mapFromDomain(domain.geo),
            menus = MenuMapper().mapFromDomain(domain.menus),
            lastUpdated = domain.lastUpdated
        )
    }

    override fun mapToDomain(model: Restaurant): RestaurantDomain {
        throw UnsupportedOperationException("Unsupported Operation")
    }
}