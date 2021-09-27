package com.bertholucci.restaurants

import androidx.fragment.app.testing.FragmentScenario
import com.bertholucci.restaurants.presentation.ui.restaurant.RestaurantFragment

fun setupView(func: AddCounterFragmentRobot.() -> Unit) =
    AddCounterFragmentRobot().apply(func)

class AddCounterFragmentRobot {

    infix fun launchView(func: RestaurantFragmentAction.() -> Unit): RestaurantFragmentAction {
        FragmentScenario.launchInContainer(
            fragmentClass = RestaurantFragment::class.java,
            fragmentArgs = null,
            themeResId = R.style.Theme_Restaurants
        )
        return RestaurantFragmentAction().apply(func)
    }
}

class RestaurantFragmentAction {

    infix fun check(func: RestaurantFragmentResult.() -> Unit) =
        RestaurantFragmentResult().apply(func)
}

class RestaurantFragmentResult {

    fun hasRightTexts() {
        Thread.sleep(1200) //This is because of the implemented delay on RestaurantsRepositoryImpl
        R.id.tv_name.hasText("Silver Spurs")
        R.id.tv_menu.hasText(R.string.menu)
        "Beverages".isTextDisplayed()
        "Smoothies".isTextDisplayed()
    }
}
