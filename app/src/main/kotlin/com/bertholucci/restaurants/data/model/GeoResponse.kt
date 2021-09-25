package com.bertholucci.restaurants.data.model

import com.google.gson.annotations.SerializedName

class GeoResponse(
    @SerializedName("lat") val lat: Double?,
    @SerializedName("lon") val lon: Double?,
)