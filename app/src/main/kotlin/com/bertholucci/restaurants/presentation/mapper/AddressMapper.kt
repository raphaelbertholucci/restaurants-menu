package com.bertholucci.restaurants.presentation.mapper

import com.bertholucci.restaurants.common.base.BaseMapper
import com.bertholucci.restaurants.domain.model.AddressDomain
import com.bertholucci.restaurants.presentation.model.Address

class AddressMapper : BaseMapper<Address, AddressDomain> {

    override fun mapFromDomain(domain: AddressDomain): Address {
        return Address(
            city = domain.city,
            state = domain.state,
            postalCode = domain.postalCode,
            street = domain.street,
            formatted = domain.formatted
        )
    }

    override fun mapToDomain(model: Address): AddressDomain {
        throw UnsupportedOperationException("Unsupported Operation")
    }
}