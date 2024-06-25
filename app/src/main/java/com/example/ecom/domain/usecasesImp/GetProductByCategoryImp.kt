package com.example.ecom.domain.usecasesImp

import com.example.ecom.data.api.models.response.ProductResponse
import com.example.ecom.data.repository.ProductRepository
import com.example.ecom.domain.usecases.GetProductByCategoryUseCase
import javax.inject.Inject

class GetProductByCategoryImp @Inject constructor(private val productRepository: ProductRepository)  : GetProductByCategoryUseCase {
    override suspend fun invoke(category: String, limit: Int): ProductResponse {
        return productRepository.getProductByCategory(category, limit)
    }
}