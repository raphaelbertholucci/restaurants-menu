package com.bertholucci.restaurants.data.model

import com.google.gson.annotations.SerializedName

class MenuSectionResponse(
    @SerializedName("section_name") val name: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("menu_items") val items: List<MenuItemResponse>?
)
