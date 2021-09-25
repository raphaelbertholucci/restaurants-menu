package com.bertholucci.restaurants.domain.di

import com.bertholucci.restaurants.domain.interactor.GetRestaurantById
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetRestaurantById(repository = get()) }
}