package com.bertholucci.restaurants.data.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.data.model.PricingResponse
import com.bertholucci.restaurants.domain.model.PricingDomain

class PricingResponseMapper : BaseMapper<PricingResponse?, PricingDomain> {

    override fun mapFromDomain(domain: PricingDomain): PricingResponse? {
        throw UnsupportedOperationException("Unsupported Operation")
    }

    override fun mapToDomain(model: PricingResponse?): PricingDomain {
        return PricingDomain(
            price = model?.price ?: 0.0,
            currency = model?.currency ?: "",
            priceString = model?.priceString ?: ""
        )
    }

    fun mapToDomainList(list: List<PricingResponse>?) = list?.map {
        mapToDomain(it)
    } ?: emptyList()
}