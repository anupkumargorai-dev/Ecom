package com.example.ecom.domain.usecases

import com.example.ecom.data.api.models.response.ProductResponse

interface GetProductByCategoryUseCase {
    suspend operator fun invoke(category: String, limit: Int): ProductResponse
}