package com.bertholucci.restaurants.data.model

import com.google.gson.annotations.SerializedName

class RestaurantResponse(
    @SerializedName("restaurant_name") val name: String?,
    @SerializedName("restaurant_phone") val phone: String?,
    @SerializedName("restaurant_website") val website: String?,
    @SerializedName("hours") val hours: String?,
    @SerializedName("price_range") val priceRange: String?,
    @SerializedName("restaurant_id") val id: Long?,
    @SerializedName("cuisines") val cuisines: List<String>?,
    @SerializedName("address") val address: AddressResponse?,
    @SerializedName("geo") val geo: GeoResponse?,
    @SerializedName("menus") val menus: MenuResponse?,
    @SerializedName("last_updated") val lastUpdated: String?
)