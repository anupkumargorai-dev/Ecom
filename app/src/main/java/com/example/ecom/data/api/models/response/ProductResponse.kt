package com.example.ecom.data.api.models.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ProductResponse(
    @SerialName("products")
    val products : List<Product>?
)

@Serializable
data class Product(
    @SerialName("id") val id: Int?,
    @SerialName("title") val title: String?,
    @SerialName("description") val description: String?,
    @SerialName("category") val category: String?,
    @SerialName("price") val price: Double?,
    @SerialName("discountPercentage") val discountPercentage: Double?,
    @SerialName("rating") val rating: Double?,
    @SerialName("stock") val stock: Int?,
    @SerialName("tags") val tags: List<String>?,
    @SerialName("brand") val brand: String?,
    @SerialName("sku") val sku: String?,
    @SerialName("weight") val weight: Int?,
    @SerialName("dimensions") val dimensions: Dimensions?,
    @SerialName("warrantyInformation") val warrantyInformation: String?,
    @SerialName("shippingInformation") val shippingInformation: String?,
    @SerialName("availabilityStatus") val availabilityStatus: String?,
    @SerialName("reviews") val reviews: List<Review>?,
    @SerialName("returnPolicy") val returnPolicy: String?,
    @SerialName("minimumOrderQuantity") val minimumOrderQuantity: Int?,
    @SerialName("meta") val meta: Meta?,
    @SerialName("images") val images: List<String>?,
    @SerialName("thumbnail") val thumbnail: String?
)

@Serializable
data class Dimensions(
    @SerialName("width") val width: Double?,
    @SerialName("height") val height: Double?,
    @SerialName("depth") val depth: Double?
)

@Serializable
data class Review(
    @SerialName("rating") val rating: Int?,
    @SerialName("comment") val comment: String?,
    @SerialName("date") val date: String?,
    @SerialName("reviewerName") val reviewerName: String?,
    @SerialName("reviewerEmail") val reviewerEmail: String?
)

@Serializable
data class Meta(
    @SerialName("createdAt") val createdAt: String?,
    @SerialName("updatedAt") val updatedAt: String?,
    @SerialName("barcode") val barcode: String?,
    @SerialName("qrCode") val qrCode: String?
)