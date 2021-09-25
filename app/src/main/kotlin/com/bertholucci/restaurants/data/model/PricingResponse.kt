package com.bertholucci.restaurants.data.model

import com.google.gson.annotations.SerializedName

class PricingResponse(
    @SerializedName("price") val price: Double?,
    @SerializedName("currency") val currency: String?,
    @SerializedName("priceString") val priceString: String?,
)
