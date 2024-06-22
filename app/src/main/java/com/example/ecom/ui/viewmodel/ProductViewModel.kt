package com.example.ecom.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecom.data.api.NetworkResult
import com.example.ecom.data.api.models.response.ProductResponse
import com.example.ecom.domain.usecases.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private val _products = MutableLiveData<NetworkResult<ProductResponse>>()
    val products: LiveData<NetworkResult<ProductResponse>> = _products

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
}