package com.bertholucci.restaurants.presentation.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bertholucci.restaurants.common.base.BaseFragment
import com.bertholucci.restaurants.common.extensions.navProvider
import com.bertholucci.restaurants.common.extensions.navigateWithAnimation
import com.bertholucci.restaurants.common.fold
import com.bertholucci.restaurants.common.helpers.ERROR
import com.bertholucci.restaurants.common.helpers.EndlessScrollListener
import com.bertholucci.restaurants.common.helpers.RESULT_SIZE
import com.bertholucci.restaurants.databinding.FragmentSearchBinding
import com.bertholucci.restaurants.presentation.model.SearchResult
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    private val navController: NavController by navProvider()
    private val viewModel: SearchViewModel by viewModel()

    private val adapter = SearchAdapter()

    override fun getViewBinding() = FragmentSearchBinding.inflate(LayoutInflater.from(context))

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObservers()
        setupAdapter()
        addListeners()

        viewModel.searchRestaurants(query = getQuery(), page = 1)
    }

    private fun addListeners() {
        binding.searchErrorView.btnRetry.setOnClickListener {
            viewModel.searchRestaurants(query = getQuery())
        }

        binding.etSearch.doOnTextChanged { text, _, _, _ ->
            text?.let {
                if (it.isNotEmpty()) {
                    viewModel.updatePage(1)
                    viewModel.searchRestaurants(text.toString())
                }
            }
        }
    }

    private fun addObservers() {
        viewModel.result.observe(viewLifecycleOwner) { response ->
            response.fold(::handleError, ::handleSearchSuccess)
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            if (viewModel.getPage() == 1) display(loading = it)
        }
    }

    private fun setupAdapter() {
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter.onClick = { id ->
            navController.navigateWithAnimation(SearchFragmentDirections.toFragmentRestaurant(id))
        }
        binding.rvRestaurants.layoutManager = layoutManager
        binding.rvRestaurants.adapter = adapter
        setupEndlessScroll(layoutManager, adapter)
    }

    private fun handleSearchSuccess(result: SearchResult) {
        val list = result.data
        adapter.isLoading = false
        when {
            list.isEmpty() -> {
                adapter.isFullyLoaded = true
                adapter.notifyDataSetChanged()
            }
            list.isNotEmpty() && viewModel.getPage() == 1 && list.size < RESULT_SIZE -> {
                adapter.isFullyLoaded = true
                adapter.setList(list)
            }
            list.isNotEmpty() && viewModel.getPage() == 1 && list.size == RESULT_SIZE -> {
                adapter.isFullyLoaded = false
                adapter.setList(list)
            }
            list.isNotEmpty() && viewModel.getPage() > 1 -> {
                adapter.isFullyLoaded = false
                adapter.updateList(list)
            }
        }
        display(content = true)
    }

    private fun handleError(throwable: Throwable) {
        Log.d(ERROR, throwable.message.toString())
        display(error = true)
    }

    private fun display(
        content: Boolean = false,
        loading: Boolean = false,
        error: Boolean = false
    ) {
        binding.progress.isVisible = loading
        binding.searchErrorView.errorGroup.isVisible = error
        binding.rvRestaurants.isVisible = content
    }

    private fun getQuery() =
        binding.etSearch.text.takeIf { it?.isNotEmpty() == true }?.toString()

    private fun setupEndlessScroll(layoutManager: LinearLayoutManager, adapter: SearchAdapter) {
        val endlessScrollListener = object : EndlessScrollListener(layoutManager) {
            override fun onLoadMore(page: Int, totalItemCount: Int) {
                adapter.isLoading = true
                viewModel.updatePage(page)
                viewModel.searchRestaurants(getQuery(), page)
            }
        }
        binding.rvRestaurants.addOnScrollListener(endlessScrollListener)
    }
}