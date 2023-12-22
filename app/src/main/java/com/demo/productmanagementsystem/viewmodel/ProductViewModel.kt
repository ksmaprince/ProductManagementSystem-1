package com.demo.productmanagementsystem.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.productmanagementsystem.data.Product
import com.demo.productmanagementsystem.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel @Inject constructor(val repository: ProductRepository): ViewModel() {

    val products = repository.getAllProducts()

    fun saveProduct(product: Product){
        viewModelScope.launch {
            repository.insertProduct(product)
        }
    }

    fun deleteProduct(product: Product){
        viewModelScope.launch {
            repository.deleteProduct(product)
        }
    }
}