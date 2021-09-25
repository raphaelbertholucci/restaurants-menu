package com.bertholucci.restaurants.common.widget

import android.content.Context
import android.view.View
import androidx.viewpager.widget.ViewPager

class DynamicViewPager(context: Context) : ViewPager(context, null) {

    private var mCurrentView: View? = null

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var mHeightMeasureSpec = heightMeasureSpec
        if (mCurrentView == null) {
            super.onMeasure(widthMeasureSpec, mHeightMeasureSpec)
            return
        }
        var height = 0
        mCurrentView?.measure(
            widthMeasureSpec,
            MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
        )
        val h: Int = mCurrentView?.measuredHeight ?: 0
        if (h > height) height = h
        mHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
        super.onMeasure(widthMeasureSpec, mHeightMeasureSpec)
    }

    fun measureCurrentView(currentView: View) {
        mCurrentView = currentView
        requestLayout()
    }
}