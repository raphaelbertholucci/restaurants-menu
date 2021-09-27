package com.bertholucci.restaurants

import androidx.test.ext.junit.runners.AndroidJUnit4
import io.mockk.MockKAnnotations
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin

@RunWith(AndroidJUnit4::class)
class RestaurantFragmentTest {

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    fun showCorrectTexts() {
        setupView {
        } launchView {
        } check {
            hasRightTexts()
        }
    }
}