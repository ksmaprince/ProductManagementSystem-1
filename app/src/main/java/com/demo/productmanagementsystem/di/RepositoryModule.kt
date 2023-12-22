package com.demo.productmanagementsystem.di

import com.demo.productmanagementsystem.data.ProductDAO
import com.demo.productmanagementsystem.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(productDao:ProductDAO): ProductRepository{
        return ProductRepository(productDao)
    }
}