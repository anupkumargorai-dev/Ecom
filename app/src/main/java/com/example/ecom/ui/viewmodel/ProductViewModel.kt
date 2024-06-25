package com.example.ecom.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecom.data.api.NetworkResult
import com.example.ecom.data.api.models.response.ProductResponse
import com.example.ecom.domain.usecases.GetBestSellerProductUseCase
import com.example.ecom.domain.usecases.GetProductByCategoryUseCase
import com.example.ecom.domain.usecases.GetProductsUseCase
import com.example.ecom.domain.usecases.GetTrendingProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getBestSellerProductUseCase: GetBestSellerProductUseCase,
    private val getProductByCategoryUseCase: GetProductByCategoryUseCase,
    private val getTrendingProductUseCase: GetTrendingProductUseCase
) : ViewModel() {

    private val _products = MutableLiveData<NetworkResult<ProductResponse>>()
    val products: LiveData<NetworkResult<ProductResponse>> = _products

    private val _bestSellerProducts = MutableLiveData<NetworkResult<ProductResponse>>()
    val bestSellerProducts: LiveData<NetworkResult<ProductResponse>> = _bestSellerProducts

    private val _trendingProducts = MutableLiveData<NetworkResult<ProductResponse>>()
    val trendingProducts: LiveData<NetworkResult<ProductResponse>> = _trendingProducts

    fun getProducts() {
        viewModelScope.launch {
            try {
                _products.postValue(NetworkResult.Loading())
                val response = getProductsUseCase.invoke()
                _products.postValue(NetworkResult.Success(response))

            }catch (e : Exception){
                e.printStackTrace()
                _products.postValue(NetworkResult.Error(e.message.toString()))
            }
        }
    }

    fun getBestSellerProducts() {
        viewModelScope.launch {
            try {
                _bestSellerProducts.postValue(NetworkResult.Loading())
                val response = getBestSellerProductUseCase.invoke()
                _bestSellerProducts.postValue(NetworkResult.Success(response))
            }catch (e : Exception) {
                e.printStackTrace()
                _bestSellerProducts.postValue(NetworkResult.Error(e.message.toString()))
            }        }
    }

    fun getTrendingProducts() {
        viewModelScope.launch {
            try {
                _trendingProducts.postValue(NetworkResult.Loading())
                val response = getTrendingProductUseCase.invoke()
                _trendingProducts.postValue(NetworkResult.Success(response))
            }catch (e : Exception) {
                e.printStackTrace()
                _trendingProducts.postValue(NetworkResult.Error(e.message.toString()))
            }
        }
    }
}