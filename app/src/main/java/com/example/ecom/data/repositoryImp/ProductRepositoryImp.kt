package com.example.ecom.data.repositoryImp

import com.example.ecom.data.api.NetworkResult
import com.example.ecom.data.api.ProductServices
import com.example.ecom.data.api.models.response.ProductResponse
import com.example.ecom.data.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImp @Inject constructor(private val productServices: ProductServices) :
    ProductRepository {

    override suspend fun getProducts(): ProductResponse {
       return productServices.getProducts()
    }

    override suspend fun getProductByCategory(category: String, limit: Int): ProductResponse {
        return productServices.getProductByCategory(category, limit)
    }
}