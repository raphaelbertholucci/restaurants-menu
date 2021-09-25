package com.bertholucci.restaurants.data.model

import com.google.gson.annotations.SerializedName

class AddressResponse(
    @SerializedName("city") val city: String?,
    @SerializedName("state") val state: String?,
    @SerializedName("postal_code") val postalCode: String?,
    @SerializedName("street") val street: String?,
    @SerializedName("formatted") val formatted: String?,
)