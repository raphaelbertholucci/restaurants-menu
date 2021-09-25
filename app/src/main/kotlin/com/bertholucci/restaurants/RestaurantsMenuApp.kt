package com.bertholucci.restaurants

import android.app.Application
import com.bertholucci.restaurants.data.di.apiModule
import com.bertholucci.restaurants.data.di.repositoryModule
import com.bertholucci.restaurants.domain.di.useCaseModule
import com.bertholucci.restaurants.presentation.di.homeModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RestaurantsMenuApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RestaurantsMenuApp)
            androidLogger()
            modules(
                listOf(
                    apiModule,
                    repositoryModule,
                    useCaseModule,
                    homeModule
                )
            )
        }
    }
}