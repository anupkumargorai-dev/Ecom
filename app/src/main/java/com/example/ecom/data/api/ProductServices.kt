package com.example.ecom.data.api

import com.example.ecom.data.api.models.response.ProductResponse
import retrofit2.http.GET

interface ProductServices {

    @GET("products")
    suspend fun getProducts() : ProductResponse
}