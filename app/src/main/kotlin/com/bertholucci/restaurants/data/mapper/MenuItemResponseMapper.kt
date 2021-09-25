package com.bertholucci.restaurants.data.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.data.model.MenuItemResponse
import com.bertholucci.restaurants.domain.model.MenuItemDomain

class MenuItemResponseMapper : BaseMapper<MenuItemResponse?, MenuItemDomain> {

    override fun mapFromDomain(domain: MenuItemDomain): MenuItemResponse? {
        throw UnsupportedOperationException("Unsupported Operation")
    }

    override fun mapToDomain(model: MenuItemResponse?): MenuItemDomain {
        return MenuItemDomain(
            name = model?.name ?: "",
            description = model?.description ?: "",
            price = model?.price ?: 0.0,
            pricing = PricingResponseMapper().mapToDomainList(model?.pricing)
        )
    }

    fun mapToDomainList(list: List<MenuItemResponse>?) = list?.map {
        mapToDomain(it)
    } ?: emptyList()
}