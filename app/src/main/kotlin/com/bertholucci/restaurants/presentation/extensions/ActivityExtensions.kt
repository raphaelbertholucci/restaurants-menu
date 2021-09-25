package com.bertholucci.restaurants.presentation.extensions

import android.app.Activity
import android.view.View
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bertholucci.restaurants.R
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnack(@StringRes resId: Int) {
    activity?.getView()?.let {
        Snackbar.make(it, resId, Snackbar.LENGTH_SHORT).apply {
            setTextColor(ContextCompat.getColor(context, R.color.white))
            view.setBackgroundColor(ContextCompat.getColor(context, R.color.red))
        }.show()
    }
}

private fun Activity.getView(): View = findViewById(android.R.id.content)