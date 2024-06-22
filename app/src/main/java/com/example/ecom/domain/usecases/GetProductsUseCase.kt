package com.example.ecom.domain.usecases

import com.example.ecom.data.api.models.response.ProductResponse

interface GetProductsUseCase {
    suspend operator fun invoke(): ProductResponse
}