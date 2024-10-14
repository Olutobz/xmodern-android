package com.dev.olutoba.xmodern_android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dev.olutoba.xmodern_android.data.repository.ProductRepository


/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 13 October, 2024
 * EMAIL: damexxey94@gmail.com
 */

@Suppress("UNCHECKED_CAST")
class ProductViewModelFactory(
    private val productRepository: ProductRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            return ProductsViewModel(productRepository) as T
        }
        throw IllegalArgumentException("Unknown viewModel class")
    }
}