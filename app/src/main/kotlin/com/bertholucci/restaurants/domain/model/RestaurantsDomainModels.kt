package com.bertholucci.restaurants.domain.model

class RestaurantDomain(
    val name: String = "",
    val phone: String = "",
    val website: String = "",
    val hours: String = "",
    val priceRange: String = "",
    val id: Long = 0,
    val cuisines: List<String> = emptyList(),
    val address: AddressDomain = AddressDomain(),
    val geo: GeoDomain = GeoDomain(),
    val menus: MenuDomain,
    val lastUpdated: String
)

class AddressDomain(
    val city: String = "",
    val state: String = "",
    val postalCode: String = "",
    val street: String = "",
    val formatted: String = "",
)

class GeoDomain(
    val lat: Double = 0.0,
    val lon: Double = 0.0,
)

class MenuDomain(
    val name: String? = "",
    val sections: List<MenuSectionDomain> = emptyList()
)

class MenuSectionDomain(
    val name: String = "",
    val description: String = "",
    val items: List<MenuItemDomain> = emptyList()
)

class MenuItemDomain(
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val pricing: List<PricingDomain> = emptyList()
)

class PricingDomain(
    val price: Double = 0.0,
    val currency: String = "",
    val priceString: String = "",
)

