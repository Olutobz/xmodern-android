package com.dev.olutoba.xmodern_android.utils


/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 13 October, 2024
 * EMAIL: damexxey94@gmail.com
 */

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val errorCode: String, val errorMessage: String) : Result<Nothing>()
}