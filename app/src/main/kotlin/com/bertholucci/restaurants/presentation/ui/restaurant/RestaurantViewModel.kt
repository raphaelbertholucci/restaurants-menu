package com.bertholucci.restaurants.presentation.ui.restaurant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bertholucci.restaurants.common.Response
import com.bertholucci.restaurants.common.base.BaseViewModel
import com.bertholucci.restaurants.domain.interactor.GetRestaurantById
import com.bertholucci.restaurants.presentation.mapper.RestaurantMapper
import com.bertholucci.restaurants.presentation.model.Restaurant
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

class RestaurantViewModel(private val restaurantById: GetRestaurantById) : BaseViewModel() {

    private val _restaurant = MutableLiveData<Response<Restaurant>>()
    val restaurant: LiveData<Response<Restaurant>>
        get() = _restaurant

    fun getRestaurantById(id: Long) {
        restaurantById(id)
            .onStart { showLoading() }
            .onCompletion { hideLoading() }
            .map { _restaurant.postValue(Response.Success(RestaurantMapper().mapFromDomain(it))) }
            .catch { _restaurant.postValue(Response.Failure(it)) }
            .launchIn(viewModelScope)
    }
}