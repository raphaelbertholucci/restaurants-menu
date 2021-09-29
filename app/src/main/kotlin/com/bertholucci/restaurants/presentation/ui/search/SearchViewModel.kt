package com.bertholucci.restaurants.presentation.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bertholucci.restaurants.common.Response
import com.bertholucci.restaurants.common.base.BaseViewModel
import com.bertholucci.restaurants.common.extensions.defaultValue
import com.bertholucci.restaurants.domain.interactor.SearchRestaurants
import com.bertholucci.restaurants.presentation.mapper.SearchResultMapper
import com.bertholucci.restaurants.presentation.model.SearchResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

private const val START_PAGE = 1

class SearchViewModel(private val searchRestaurants: SearchRestaurants) : BaseViewModel() {

    private val page = MutableLiveData<Int>().defaultValue(START_PAGE)

    private val _result = MutableLiveData<Response<SearchResult>>()
    val result: LiveData<Response<SearchResult>>
        get() = _result

    fun searchRestaurants(query: String? = null, page: Int = 1) {
        searchRestaurants(requestValues = Pair(query, page))
            .onStart { showLoading() }
            .onCompletion { hideLoading() }
            .map {
                _result.postValue(Response.Success(SearchResultMapper().mapFromDomain(it)))
            }
            .catch { _result.postValue(Response.Failure(it)) }
            .launchIn(viewModelScope)
    }

    fun updatePage(index: Int) {
        page.value = index
    }

    fun getPage() = page.value ?: START_PAGE
}