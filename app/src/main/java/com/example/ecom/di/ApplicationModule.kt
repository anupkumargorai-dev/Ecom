package com.example.ecom.di

import com.example.ecom.data.api.ProductServices
import com.example.ecom.data.repository.ProductRepository
import com.example.ecom.data.repositoryImp.ProductRepositoryImp
import com.example.ecom.domain.usecases.GetProductsUseCase
import com.example.ecom.domain.usecasesImp.GetProductsUseCaseImp
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
}