package com.bertholucci.restaurants.common.extensions

import android.content.Context
import android.content.Intent

private const val ACTION_HOME = "HOME"

fun Context.intentForAction(action: String, vararg flags: Int) = Intent().apply {
    setAction("$packageName.$action")
    flags.forEach { addFlags(it) }
}

fun Context.intentToHome() = intentForAction(ACTION_HOME)