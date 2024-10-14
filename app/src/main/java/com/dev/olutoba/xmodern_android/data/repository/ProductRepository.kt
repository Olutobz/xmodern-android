package com.dev.olutoba.xmodern_android.data.repository

import com.dev.olutoba.xmodern_android.model.Product
import com.dev.olutoba.xmodern_android.utils.Result
import kotlinx.coroutines.flow.Flow


/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 12 October, 2024
 * EMAIL: damexxey94@gmail.com
 */

interface ProductRepository {

    fun fetchProducts(): Flow<Result<List<Product>>>
}