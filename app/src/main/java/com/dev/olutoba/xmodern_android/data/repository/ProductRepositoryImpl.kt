package com.dev.olutoba.xmodern_android.data.repository

import com.dev.olutoba.xmodern_android.data.datasource.remote.ProductRemoteDataSource
import com.dev.olutoba.xmodern_android.model.Product
import com.dev.olutoba.xmodern_android.utils.Constants.GENERIC_ERROR_CODE
import com.dev.olutoba.xmodern_android.utils.Constants.GENERIC_ERROR_MESSAGE
import com.dev.olutoba.xmodern_android.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 12 October, 2024
 * EMAIL: damexxey94@gmail.com
 */

class ProductRepositoryImpl(
    private val productRemoteDataSource: ProductRemoteDataSource
) : ProductRepository {

    override fun fetchProducts(): Flow<Result<List<Product>>> = flow {
        when (val result = productRemoteDataSource.fetchProducts()) {
            is Result.Success -> {
                emit(Result.Success(result.data.products.orEmpty()))
            }

            is Result.Error -> {
                emit(Result.Error(result.errorCode, result.errorMessage))
            }
        }
    }.catch {
        emit(Result.Error(GENERIC_ERROR_CODE, GENERIC_ERROR_MESSAGE))
    }.flowOn(Dispatchers.IO)
}