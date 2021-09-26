package com.bertholucci.restaurants

import com.bertholucci.restaurants.data.model.AddressResponse
import com.bertholucci.restaurants.data.model.GeoResponse
import com.bertholucci.restaurants.data.model.MenuItemResponse
import com.bertholucci.restaurants.data.model.MenuResponse
import com.bertholucci.restaurants.data.model.MenuSectionResponse
import com.bertholucci.restaurants.data.model.PricingResponse
import com.bertholucci.restaurants.data.model.RestaurantDataResponse
import com.bertholucci.restaurants.data.model.RestaurantResponse
import com.bertholucci.restaurants.domain.model.AddressDomain
import com.bertholucci.restaurants.domain.model.GeoDomain
import com.bertholucci.restaurants.domain.model.MenuDomain
import com.bertholucci.restaurants.domain.model.MenuItemDomain
import com.bertholucci.restaurants.domain.model.MenuSectionDomain
import com.bertholucci.restaurants.domain.model.PricingDomain
import com.bertholucci.restaurants.domain.model.RestaurantDomain


val restaurantMock = RestaurantDomain(
    name = "Restaurant Name",
    phone = "+19549999999",
    website = "www.restaurant.com",
    hours = "11 A.M. to 23 P.M.",
    priceRange = "$",
    id = 1234567890,
    cuisines = listOf("Italian"),
    address = AddressDomain(
        city = "Boston",
        state = "MA",
        "02115",
        street = "Internet",
        formatted = "Internet, Boston, MA 02115, US"
    ),
    geo = GeoDomain(lon = 12.1234567, lat = 21.23232323),
    menus = listOf(
        MenuDomain(
            name = "Main",
            sections = listOf(
                MenuSectionDomain(
                    name = "Beverages",
                    description = "",
                    items = listOf(
                        MenuItemDomain(
                            name = "Regular Coffee",
                            description = "",
                            price = 1.50,
                            pricing = listOf(
                                PricingDomain(
                                    price = 1.50,
                                    currency = "USD",
                                    priceString = "$1.50"
                                )
                            )
                        )
                    )
                )
            )
        )
    ),
    lastUpdated = "2021-01-05T07:20:33.079Z"
)

val restaurantResponseMock = RestaurantDataResponse(
    result = RestaurantResponse(
        name = "Restaurant Name",
        phone = "+19549999999",
        website = "www.restaurant.com",
        hours = "11 A.M. to 23 P.M.",
        priceRange = "$",
        id = 1234567890,
        cuisines = listOf("Italian"),
        address = AddressResponse(
            city = "Boston",
            state = "MA",
            "02115",
            street = "Internet",
            formatted = "Internet, Boston, MA 02115, US"
        ),
        geo = GeoResponse(lon = 12.1234567, lat = 21.23232323),
        menus = listOf(
            MenuResponse(
                name = "Main",
                sections = listOf(
                    MenuSectionResponse(
                        name = "Beverages",
                        description = "",
                        items = listOf(
                            MenuItemResponse(
                                name = "Regular Coffee",
                                description = "",
                                price = 1.50,
                                pricing = listOf(
                                    PricingResponse(
                                        price = 1.50,
                                        currency = "USD",
                                        priceString = "$1.50"
                                    )
                                )
                            )
                        )
                    )
                )
            )
        ),
        lastUpdated = "2021-01-05T07:20:33.079Z"
    )
)