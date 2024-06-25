package com.example.ecom.domain.usecases

import com.example.ecom.data.api.models.response.ProductResponse

interface GetTrendingProductUseCase  {
    suspend operator fun invoke(): ProductResponse
}