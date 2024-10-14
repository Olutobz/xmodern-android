package com.dev.olutoba.xmodern_android.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    val id: Int?,
    val title: String?,
    val description: String?,
    val category: String?,
    val price: Double?,
    val discountPercentage: Double?,
    val rating: Double?,
    val stock: Int?,
    val tags: List<String>?,
    val brand: String?,
    val sku: String?,
    val weight: Int?,
    val dimensions: Dimensions?,
    val warrantyInformation: String?,
    val shippingInformation: String?,
    val availabilityStatus: String?,
    val reviews: List<Review>?,
    val returnPolicy: String?,
    val minimumOrderQuantity: Int?,
    val meta: Meta?,
    val images: List<String>?,
    val thumbnail: String?
)

@JsonClass(generateAdapter = true)
data class Dimensions(
    val depth: Double,
    val height: Double,
    val width: Double
)

@JsonClass(generateAdapter = true)
data class Meta(
    val barcode: String,
    val createdAt: String,
    val qrCode: String,
    val updatedAt: String
)

@JsonClass(generateAdapter = true)
data class Review(
    val rating: Int,
    val comment: String,
    val date: String,
    val reviewerName: String,
    val reviewerEmail: String
)