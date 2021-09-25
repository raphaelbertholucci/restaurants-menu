package com.bertholucci.restaurants.presentation.ui

import android.view.LayoutInflater
import com.bertholucci.restaurants.common.base.BaseActivity
import com.bertholucci.restaurants.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override fun getViewBinding() = ActivityHomeBinding.inflate(LayoutInflater.from(this))
}