package com.demo.productmanagementsystem

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.productmanagementsystem.adapters.ProductAdapter
import com.demo.productmanagementsystem.data.Product
import com.demo.productmanagementsystem.data.ProductDB
import com.demo.productmanagementsystem.databinding.ActivityMainBinding
import com.demo.productmanagementsystem.repository.ProductRepository
import com.demo.productmanagementsystem.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private val viewModel: ProductViewModel by viewModels()
    @Inject lateinit var viewModel: ProductViewModel
    @Inject lateinit var adapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvProduct.layoutManager = LinearLayoutManager(this)
        binding.rvProduct.adapter = adapter

        viewModel.products.observe(this, Observer {
            adapter.products = it
        })

        binding.btnAddProduct.setOnClickListener {
            startActivity(AddProductActivity.newIntent(this))
        }

        adapter.setOnImageClickListener(object : ProductAdapter.OnImageClickListener {
            override fun onImageClick(product: Product) {
                Toast.makeText(this@MainActivity, "${product.title} is clicked", Toast.LENGTH_LONG)
                    .show()
            }
        })

        adapter.setOnIconDeleteClickListener(object : ProductAdapter.OnIconDeleteClickListener {
            override fun onDeleteIconClick(product: Product) {
                viewModel.deleteProduct(product)
            }

        })
    }
}
