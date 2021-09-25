package com.bertholucci.restaurants.data.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.data.model.MenuSectionResponse
import com.bertholucci.restaurants.domain.model.MenuSectionDomain

class MenuSectionResponseMapper : BaseMapper<MenuSectionResponse?, MenuSectionDomain> {

    override fun mapFromDomain(domain: MenuSectionDomain): MenuSectionResponse? {
        throw UnsupportedOperationException("Unsupported Operation")
    }

    override fun mapToDomain(model: MenuSectionResponse?): MenuSectionDomain {
        return MenuSectionDomain(
            name = model?.name ?: "",
            description = model?.description ?: "",
            items = MenuItemResponseMapper().mapToDomainList(model?.items)
        )
    }

    fun mapToDomainList(list: List<MenuSectionResponse>?) = list?.map {
        mapToDomain(it)
    } ?: emptyList()
}