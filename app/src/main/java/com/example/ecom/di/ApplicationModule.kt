package com.example.ecom.di

import com.example.ecom.data.api.ProductServices
import com.example.ecom.data.repository.ProductRepository
import com.example.ecom.data.repositoryImp.ProductRepositoryImp
import com.example.ecom.domain.usecases.GetBestSellerProductUseCase
import com.example.ecom.domain.usecases.GetProductByCategoryUseCase
import com.example.ecom.domain.usecases.GetProductsUseCase
import com.example.ecom.domain.usecases.GetTrendingProductUseCase
import com.example.ecom.domain.usecasesImp.GetBestSellerProductUseCaseImp
import com.example.ecom.domain.usecasesImp.GetProductByCategoryImp
import com.example.ecom.domain.usecasesImp.GetProductsUseCaseImp
import com.example.ecom.domain.usecasesImp.GetTrendingProductUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideProductRepository(productServices: ProductServices) : ProductRepository {
        return ProductRepositoryImp(productServices)
    }

    @Provides
    @Singleton
    fun providesProductUseCase(productRepository: ProductRepository) : GetProductsUseCase {
        return GetProductsUseCaseImp(productRepository)
    }

    @Provides
    @Singleton
    fun provideBestSellerProductUseCase(productRepository: ProductRepository) : GetBestSellerProductUseCase {
        return GetBestSellerProductUseCaseImp(productRepository)
    }

    @Provides
    @Singleton
    fun provideTrendingProductUseCase(productRepository: ProductRepository) : GetTrendingProductUseCase {
        return GetTrendingProductUseCaseImp(productRepository)
    }

    @Provides
    @Singleton
    fun provideProductByCategoryUseCase(productRepository: ProductRepository) : GetProductByCategoryUseCase {
        return GetProductByCategoryImp(productRepository)
    }

}