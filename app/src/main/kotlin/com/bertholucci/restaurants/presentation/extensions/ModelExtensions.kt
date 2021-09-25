package com.bertholucci.restaurants.presentation.extensions

import com.bertholucci.restaurants.presentation.model.MenuItem
import java.util.*

fun List<MenuItem>.toArrayList() = this as ArrayList<MenuItem>
