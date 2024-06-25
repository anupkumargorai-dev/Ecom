package com.example.ecom.domain.usecasesImp

import com.example.ecom.data.api.models.response.Product
import com.example.ecom.data.api.models.response.ProductResponse
import com.example.ecom.data.models.product.ProductCategories
import com.example.ecom.data.repository.ProductRepository
import com.example.ecom.domain.usecases.GetBestSellerProductUseCase
import javax.inject.Inject

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class GetBestSellerProductUseCaseImp @Inject constructor(private val productRepository: ProductRepository) :
    GetBestSellerProductUseCase {

    override suspend fun invoke(): ProductResponse = coroutineScope {
        val product = mutableListOf<Product>()

        // Launching async operations for each category
        val smartPhoneDeferred = async { productRepository.getProductByCategory(ProductCategories.SMARTPHONES.categoryName, limit = 10) }
        val beautyDeferred = async { productRepository.getProductByCategory(ProductCategories.BEAUTY.categoryName, limit = 10) }
        val mensWatchDeferred = async { productRepository.getProductByCategory(ProductCategories.MENS_WATCHES.categoryName, limit = 10) }
        val mensShoesDeferred = async { productRepository.getProductByCategory(ProductCategories.MENS_SHOES.categoryName, limit = 10) }
        val sunglassesDeferred = async { productRepository.getProductByCategory(ProductCategories.SUNGLASSES.categoryName, limit = 10) }
        val laptopsDeferred = async { productRepository.getProductByCategory(ProductCategories.LAPTOPS.categoryName, limit = 10) }
        val skinCareDeferred = async { productRepository.getProductByCategory(ProductCategories.SKIN_CARE.categoryName, limit = 10) }

        // Awaiting the results of all async operations
        val responses = awaitAll(smartPhoneDeferred, beautyDeferred, mensWatchDeferred, mensShoesDeferred, sunglassesDeferred, laptopsDeferred, skinCareDeferred)

        // Adding the products from each response to the product list
        responses.forEach { response ->
            product.addAll(response.products ?: emptyList())
        }

        product.shuffle()
        ProductResponse(product)
    }
}
