package com.bertholucci.restaurants.data.di

import com.bertholucci.restaurants.data.repository.RestaurantsRepositoryImpl
import com.bertholucci.restaurants.domain.repository.RestaurantsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<RestaurantsRepository> { RestaurantsRepositoryImpl(api = get()) }
}