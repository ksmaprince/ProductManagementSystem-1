package com.demo.productmanagementsystem.di

import android.content.Context
import androidx.room.Room
import com.demo.productmanagementsystem.data.ProductDAO
import com.demo.productmanagementsystem.data.ProductDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DBModule {

    @Provides
    fun provideProductDao(productDB: ProductDB): ProductDAO{
        return productDB.getProductDao()
    }

    @Provides
    @Singleton
    fun provideProductDB(@ApplicationContext context: Context): ProductDB{
        return Room.databaseBuilder(
            context,
            ProductDB::class.java,
            "product_db"
        ).build()
    }
}