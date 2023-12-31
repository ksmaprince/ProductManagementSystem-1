package com.demo.productmanagementsystem.repository

import androidx.lifecycle.LiveData
import com.demo.productmanagementsystem.data.Product
import com.demo.productmanagementsystem.data.ProductDAO

class ProductRepository(val productDao: ProductDAO) {

    suspend fun insertProduct(product: Product) {
        productDao.insertProduct(product)
    }

    fun getAllProducts(): LiveData<List<Product>> {
        return productDao.getAllProduct()
    }

    suspend fun deleteProduct(product: Product) {
        productDao.deleteProuct(product)
    }

    suspend fun updateProduct(product: Product){
        productDao.updateProduct(product)
    }
}