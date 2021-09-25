package com.bertholucci.restaurants.presentation.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.domain.model.MenuDomain
import com.bertholucci.restaurants.presentation.model.Menu

class MenuMapper : BaseMapper<Menu, MenuDomain> {

    override fun mapFromDomain(domain: MenuDomain): Menu {
        return Menu(
            name = domain.name,
            sections = MenuSectionMapper().mapFromDomainList(domain.sections)
        )
    }

    override fun mapToDomain(model: Menu): MenuDomain {
        throw UnsupportedOperationException("Unsupported Operation")
    }
}