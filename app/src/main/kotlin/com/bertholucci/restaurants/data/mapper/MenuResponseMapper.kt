package com.bertholucci.restaurants.data.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.data.model.MenuResponse
import com.bertholucci.restaurants.domain.model.MenuDomain

class MenuResponseMapper : BaseMapper<MenuResponse?, MenuDomain> {

    override fun mapFromDomain(domain: MenuDomain): MenuResponse {
        throw UnsupportedOperationException("Unsupported Operation")
    }

    override fun mapToDomain(model: MenuResponse?): MenuDomain {
        return MenuDomain(
            name = model?.name,
            sections = MenuSectionResponseMapper().mapToDomainList(model?.sections)
        )
    }
}