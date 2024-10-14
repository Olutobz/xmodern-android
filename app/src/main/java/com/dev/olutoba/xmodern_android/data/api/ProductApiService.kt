package com.dev.olutoba.xmodern_android.data.api

import com.dev.olutoba.xmodern_android.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET


/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 12 October, 2024
 * EMAIL: damexxey94@gmail.com
 */

interface ProductApiService {

    @GET("products")
    suspend fun fetchProducts(): Response<ProductResponse>

}