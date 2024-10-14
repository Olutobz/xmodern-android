package com.dev.olutoba.xmodern_android.model


/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 13 October, 2024
 * EMAIL: damexxey94@gmail.com
 */

data class ProductListingUiState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false
)
