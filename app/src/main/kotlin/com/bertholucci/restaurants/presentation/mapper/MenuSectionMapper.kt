package com.bertholucci.restaurants.presentation.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.domain.model.MenuSectionDomain
import com.bertholucci.restaurants.presentation.model.MenuSection

class MenuSectionMapper : BaseMapper<MenuSection, MenuSectionDomain> {

    override fun mapFromDomain(domain: MenuSectionDomain): MenuSection {
        return MenuSection(
            name = domain.name,
            description = domain.description,
            items = MenuItemMapper().mapFromDomainList(domain.items)
        )
    }

    override fun mapToDomain(model: MenuSection): MenuSectionDomain {
        throw UnsupportedOperationException("Unsupported Operation")
    }

    fun mapFromDomainList(list: List<MenuSectionDomain>) = list.map {
        mapFromDomain(it)
    }
}