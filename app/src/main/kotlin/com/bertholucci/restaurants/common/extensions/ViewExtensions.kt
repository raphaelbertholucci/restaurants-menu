package com.bertholucci.restaurants.common.extensions

import android.os.Build
import android.util.TypedValue
import android.view.View
import androidx.annotation.AttrRes
import androidx.core.content.ContextCompat

fun View.addRipple(@AttrRes themeAttribute: Int = android.R.attr.selectableItemBackgroundBorderless) {
    val typedValue = TypedValue()
    context.theme.resolveAttribute(themeAttribute, typedValue, true)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        foreground = ContextCompat.getDrawable(context, typedValue.resourceId)
    } else {
        background = ContextCompat.getDrawable(context, typedValue.resourceId)
    }
}