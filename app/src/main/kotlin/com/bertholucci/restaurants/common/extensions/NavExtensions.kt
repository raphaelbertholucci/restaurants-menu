package com.bertholucci.restaurants.common.extensions

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bertholucci.restaurants.R
import kotlin.reflect.KProperty

fun AppCompatActivity.navProvider(@IdRes idRes: Int) = NavControllerProvider(idRes)

fun Fragment.navProvider() = NavControllerProvider()

class NavControllerProvider(@IdRes private val idRes: Int = 0) {

    operator fun getValue(ref: AppCompatActivity, property: KProperty<*>): NavController {
        return ref.findNavController(idRes)
    }

    operator fun getValue(ref: Fragment, property: KProperty<*>): NavController {
        return ref.findNavController()
    }
}

private val navOptions = NavOptions.Builder()
    .setEnterAnim(R.anim.slide_in_right)
    .setExitAnim(R.anim.slide_in_left)
    .setPopEnterAnim(R.anim.slide_out_left)
    .setPopExitAnim(R.anim.slide_out_right)
    .build()

fun NavController.navigateWithAnimation(destination: NavDirections) {
    this.navigate(destination, navOptions)
}
