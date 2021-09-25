package com.bertholucci.restaurants.data.model

import com.google.gson.annotations.SerializedName

class RestaurantDataResponse(@SerializedName("result") val result: RestaurantResponse)