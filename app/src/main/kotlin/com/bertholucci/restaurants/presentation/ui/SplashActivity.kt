package com.bertholucci.restaurants.presentation.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bertholucci.restaurants.common.base.BaseActivity
import com.bertholucci.restaurants.common.extensions.intentToHome
import com.bertholucci.restaurants.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun getViewBinding() = ActivitySplashBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed(::navigateToHome, 2500)
    }

    private fun navigateToHome() {
        startActivity(intentToHome())
    }
}