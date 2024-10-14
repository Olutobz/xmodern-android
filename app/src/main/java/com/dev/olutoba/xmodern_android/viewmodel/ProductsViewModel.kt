package com.dev.olutoba.xmodern_android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.olutoba.xmodern_android.data.repository.ProductRepository
import com.dev.olutoba.xmodern_android.model.ProductListingUiState
import com.dev.olutoba.xmodern_android.utils.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 13 October, 2024
 * EMAIL: damexxey94@gmail.com
 */

class ProductsViewModel(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductListingUiState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            productRepository.fetchProducts().collect { result ->
                when (result) {
                    is Result.Success -> {
                        _uiState.update {
                            it.copy(products = result.data, isLoading = false)
                        }
                    }

                    is Result.Error -> {
                        _uiState.update { it.copy(isLoading = false) }
                    }
                }
            }
        }
    }

}