package com.bertholucci.restaurants.presentation.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.domain.model.MenuItemDomain
import com.bertholucci.restaurants.presentation.model.MenuItem

class MenuItemMapper : BaseMapper<MenuItem, MenuItemDomain> {

    override fun mapFromDomain(domain: MenuItemDomain): MenuItem {
        return MenuItem(
            name = domain.name,
            description = domain.description,
            price = domain.price,
            pricing = PricingMapper().mapFromDomainList(domain.pricing)
        )
    }

    override fun mapToDomain(model: MenuItem): MenuItemDomain {
        throw UnsupportedOperationException("Unsupported Operation")
    }

    fun mapFromDomainList(list: List<MenuItemDomain>) = list.map {
        mapFromDomain(it)
    }
}