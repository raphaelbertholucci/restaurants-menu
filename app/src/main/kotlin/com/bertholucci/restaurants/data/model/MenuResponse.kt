package com.bertholucci.restaurants.data.model

import com.google.gson.annotations.SerializedName

class MenuResponse(
    @SerializedName("menu_name") val name: String?,
    @SerializedName("menu_sections") val sections: List<MenuSectionResponse>?
)
