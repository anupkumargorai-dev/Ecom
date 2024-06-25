package com.example.ecom.domain.usecasesImp

import com.example.ecom.data.api.models.response.Product
import com.example.ecom.data.api.models.response.ProductResponse
import com.example.ecom.data.models.product.ProductCategories
import com.example.ecom.data.repository.ProductRepository
import com.example.ecom.domain.usecases.GetBestSellerProductUseCase
import com.example.ecom.domain.usecases.GetTrendingProductUseCase
import javax.inject.Inject

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class GetTrendingProductUseCaseImp @Inject constructor(private val productRepository: ProductRepository) :
    GetTrendingProductUseCase {

    override suspend fun invoke(): ProductResponse = coroutineScope {
        val product = mutableListOf<Product>()

        // Launching async operations for each category
        val smartPhoneDeferred = async { productRepository.getProductByCategory(ProductCategories.TOPS.categoryName, limit = 10) }
        val beautyDeferred = async { productRepository.getProductByCategory(ProductCategories.MENS_SHIRTS.categoryName, limit = 10) }
        val mensWatchDeferred = async { productRepository.getProductByCategory(ProductCategories.HOME_DECORATION.categoryName, limit = 10) }
        val mensShoesDeferred = async { productRepository.getProductByCategory(ProductCategories.KITCHEN_ACCESSORIES.categoryName, limit = 10) }
        val sunglassesDeferred = async { productRepository.getProductByCategory(ProductCategories.WOMENS_SHOES.categoryName, limit = 10) }
        val laptopsDeferred = async { productRepository.getProductByCategory(ProductCategories.FURNITURE.categoryName, limit = 10) }
        val skinCareDeferred = async { productRepository.getProductByCategory(ProductCategories.FRAGRANCES.categoryName, limit = 10) }

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
