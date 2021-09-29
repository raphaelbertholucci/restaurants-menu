package com.bertholucci.restaurants.data.model

import com.google.gson.annotations.SerializedName

class RestaurantDataResponse(@SerializedName("result") val result: RestaurantResponse)

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
    @SerializedName("menus") val menus: List<MenuResponse>?,
    @SerializedName("last_updated") val lastUpdated: String?
)

class AddressResponse(
    @SerializedName("city") val city: String?,
    @SerializedName("state") val state: String?,
    @SerializedName("postal_code") val postalCode: String?,
    @SerializedName("street") val street: String?,
    @SerializedName("formatted") val formatted: String?,
)

class GeoResponse(
    @SerializedName("lat") val lat: Double?,
    @SerializedName("lon") val lon: Double?,
)

class MenuResponse(
    @SerializedName("menu_name") val name: String?,
    @SerializedName("menu_sections") val sections: List<MenuSectionResponse>?
)

class MenuSectionResponse(
    @SerializedName("section_name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("menu_items") val items: List<MenuItemResponse>?
)

class MenuItemResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("price") val price: Double?,
    @SerializedName("pricing") val pricing: List<PricingResponse>?
)

class PricingResponse(
    @SerializedName("price") val price: Double?,
    @SerializedName("currency") val currency: String?,
    @SerializedName("priceString") val priceString: String?,
)
