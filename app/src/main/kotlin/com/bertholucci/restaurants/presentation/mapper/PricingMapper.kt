package com.bertholucci.restaurants.presentation.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.domain.model.PricingDomain
import com.bertholucci.restaurants.presentation.model.Pricing

class PricingMapper : BaseMapper<Pricing, PricingDomain> {

    override fun mapFromDomain(domain: PricingDomain): Pricing {
        return Pricing(
            price = domain.price,
            currency = domain.currency,
            priceString = domain.priceString
        )
    }

    override fun mapToDomain(model: Pricing): PricingDomain {
        throw UnsupportedOperationException("Unsupported Operation")
    }

    fun mapFromDomainList(list: List<PricingDomain>) = list.map {
        mapFromDomain(it)
    }
}