package com.example.ecom.domain.usecasesImp

import com.example.ecom.data.api.NetworkResult
import com.example.ecom.data.api.models.response.ProductResponse
import com.example.ecom.data.repository.ProductRepository
import com.example.ecom.domain.usecases.GetProductsUseCase
import javax.inject.Inject

class GetProductsUseCaseImp @Inject constructor(private val productRepository: ProductRepository) :
    GetProductsUseCase {

    override suspend fun invoke(): ProductResponse {
        return productRepository.getProducts()
    }
}