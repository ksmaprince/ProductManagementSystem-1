package com.demo.productmanagementsystem.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_table")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "product_title")
    val title: String,
    @ColumnInfo(name = "product_origin")
    val origin:String,
    @ColumnInfo(name = "product_price")
    val price: String
)
