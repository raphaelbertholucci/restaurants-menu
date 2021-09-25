package com.bertholucci.restaurants.data.model

import com.google.gson.annotations.SerializedName

class MenuItemResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("price") val price: Double?,
    @SerializedName("pricing") val pricing: List<PricingResponse>?
)
