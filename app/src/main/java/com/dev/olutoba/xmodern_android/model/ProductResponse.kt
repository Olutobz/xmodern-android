package com.dev.olutoba.xmodern_android.model

import com.squareup.moshi.JsonClass


/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 13 October, 2024
 * EMAIL: damexxey94@gmail.com
 */

@JsonClass(generateAdapter = true)
data class ProductResponse(
    val products: List<Product>?,
    val total: Int,
    val skip: Int,
    val limit: Int
)
