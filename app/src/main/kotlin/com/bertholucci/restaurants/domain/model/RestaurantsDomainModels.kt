package com.bertholucci.restaurants.domain.model

data class RestaurantDomain(
    val name: String = "",
    val phone: String = "",
    val website: String = "",
    val hours: String = "",
    val priceRange: String = "",
    val id: Long = 0,
    val cuisines: List<String> = emptyList(),
    val address: AddressDomain = AddressDomain(),
    val geo: GeoDomain = GeoDomain(),
    val menus: List<MenuDomain>,
    val lastUpdated: String
)

data class AddressDomain(
    val city: String = "",
    val state: String = "",
    val postalCode: String = "",
    val street: String = "",
    val formatted: String = "",
)

data class GeoDomain(
    val lat: Double = 0.0,
    val lon: Double = 0.0,
)

data class MenuDomain(
    val name: String? = "",
    val sections: List<MenuSectionDomain> = emptyList()
)

data class MenuSectionDomain(
    val name: String = "",
    val description: String = "",
    val items: List<MenuItemDomain> = emptyList()
)

data class MenuItemDomain(
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val pricing: List<PricingDomain> = emptyList()
)

data class PricingDomain(
    val price: Double = 0.0,
    val currency: String = "",
    val priceString: String = "",
)

