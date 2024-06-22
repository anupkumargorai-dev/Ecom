package com.example.ecom.data.repository

import com.example.ecom.data.api.NetworkResult
import com.example.ecom.data.api.models.response.ProductResponse

interface ProductRepository {

    suspend fun getProducts(): ProductResponse

}