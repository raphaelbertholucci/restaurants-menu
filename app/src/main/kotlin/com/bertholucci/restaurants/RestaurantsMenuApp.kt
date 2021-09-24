package com.bertholucci.restaurants

import android.app.Application
import com.bertholucci.restaurants.di.apiModule
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
                    apiModule
                )
            )
        }
    }
}