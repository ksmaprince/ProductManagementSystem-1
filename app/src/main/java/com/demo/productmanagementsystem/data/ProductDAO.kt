package com.demo.productmanagementsystem.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(product: Product)


    @Query("SELECT * FROM product_table")
    fun getAllProduct(): LiveData<List<Product>>

    @Delete
    suspend fun deleteProuct(product: Product)

    @Update
    suspend fun updateProduct(product: Product)
}