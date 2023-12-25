package com.demo.productmanagementsystem.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.productmanagementsystem.data.Product
import com.demo.productmanagementsystem.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel @Inject constructor(val repository: ProductRepository) : ViewModel() {

    val products = repository.getAllProducts()

    fun saveProduct(product: Product) {
        viewModelScope.launch {
            repository.insertProduct(product)
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            repository.deleteProduct(product)
        }
    }

    fun updateProduct(product: Product){
        viewModelScope.launch {
            repository.updateProduct(product)
        }
    }

    val _product = MutableLiveData<Product>()
    val product: LiveData<Product>
        get() = _product

    fun setProduct(product: Product){
        _product.value = product
    }
}