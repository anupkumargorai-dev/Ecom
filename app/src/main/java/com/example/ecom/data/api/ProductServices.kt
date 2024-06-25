package com.example.ecom.data.api

import com.example.ecom.data.api.models.response.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductServices {

    @GET("products")
    suspend fun getProducts() : ProductResponse

    @GET("products/category/{category}")
    suspend fun getProductByCategory(
        @Path("category") category: String,
        @Query("limit") limit: Int
    ): ProductResponse
}