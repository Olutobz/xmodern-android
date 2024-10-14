package com.dev.olutoba.xmodern_android.data.datasource.remote

import com.dev.olutoba.xmodern_android.data.api.ProductApiService
import com.dev.olutoba.xmodern_android.di.RetrofitInstance
import com.dev.olutoba.xmodern_android.model.ProductResponse
import com.dev.olutoba.xmodern_android.utils.Constants.GENERIC_ERROR_CODE
import com.dev.olutoba.xmodern_android.utils.Constants.GENERIC_ERROR_MESSAGE
import com.dev.olutoba.xmodern_android.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 12 October, 2024
 * EMAIL: damexxey94@gmail.com
 */

class ProductRemoteDataSource(
    private val productApiService: ProductApiService =
        RetrofitInstance.createService(ProductApiService::class.java)
) {

    suspend fun fetchProducts(): Result<ProductResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response = productApiService.fetchProducts()
                if (response.isSuccessful && response.body() != null) {
                    Result.Success(data = response.body()!!)
                } else {
                    Result.Error(
                        errorCode = "${response.code()}",
                        errorMessage = response.message()
                    )
                }
            } catch (_: Exception) {
                Result.Error(GENERIC_ERROR_CODE, GENERIC_ERROR_MESSAGE)
            }
        }
    }
}