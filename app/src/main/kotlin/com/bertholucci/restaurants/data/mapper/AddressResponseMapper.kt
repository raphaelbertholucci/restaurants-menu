package com.bertholucci.restaurants.data.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.data.model.AddressResponse
import com.bertholucci.restaurants.domain.model.AddressDomain

class AddressResponseMapper : BaseMapper<AddressResponse?, AddressDomain> {

    override fun mapFromDomain(domain: AddressDomain): AddressResponse {
        throw UnsupportedOperationException("Unsupported Operation")
    }

    override fun mapToDomain(model: AddressResponse?): AddressDomain {
        return AddressDomain(
            city = model?.city ?: "",
            state = model?.state ?: "",
            postalCode = model?.postalCode ?: "",
            street = model?.street ?: "",
            formatted = model?.formatted ?: ""
        )
    }
}