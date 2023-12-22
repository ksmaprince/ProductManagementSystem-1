package com.demo.productmanagementsystem.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Product::class], exportSchema = false, version = 1)
abstract class ProductDB : RoomDatabase() {

    abstract fun getProductDao(): ProductDAO

//    companion object {
//        @Volatile
//        var INSTANCE: ProductDB? = null
//
//        fun getDBInstance(context: Context): ProductDB {
//            synchronized(this) {
//                var instance = INSTANCE
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        ProductDB::class.java,
//                        "product_db"
//                    ).build()
//                }
//                return instance
//            }
//        }
//    }
}