package com.bertholucci.restaurants.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

class Restaurant(
    val name: String = "",
    val phone: String = "",
    val website: String = "",
    val hours: String = "",
    val priceRange: String = "",
    val id: Long = 0,
    val cuisines: List<String> = emptyList(),
    val address: Address = Address(),
    val geo: Geo = Geo(),
    val menus: Menu,
    val lastUpdated: String
)

class Address(
    val city: String = "",
    val state: String = "",
    val postalCode: String = "",
    val street: String = "",
    val formatted: String = "",
)

class Geo(
    val lat: Double = 0.0,
    val lon: Double = 0.0,
)

@Parcelize
class Menu(
    val name: String? = "",
    val sections: List<MenuSection> = emptyList()
) : Parcelable

@Parcelize
class MenuSection(
    val name: String = "",
    val description: String = "",
    val items: List<MenuItem> = emptyList()
) : Parcelable

@Parcelize
class MenuItem(
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val pricing: List<Pricing> = emptyList()
) : Parcelable

@Parcelize
class Pricing(
    val price: Double = 0.0,
    val currency: String = "",
    val priceString: String = "",
) : Parcelable

