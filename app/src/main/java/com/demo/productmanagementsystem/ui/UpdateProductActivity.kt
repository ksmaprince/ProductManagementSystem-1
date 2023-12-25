package com.demo.productmanagementsystem.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.productmanagementsystem.data.Product
import com.demo.productmanagementsystem.databinding.ActivityUpdateProductBinding
import com.demo.productmanagementsystem.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UpdateProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateProductBinding
    @Inject
    lateinit var viewModel: ProductViewModel

    companion object {
        fun getIntent(context: Context, product: Product): Intent {
            val intent = Intent(context, UpdateProductActivity::class.java)
            intent.putExtra("product", product)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val product = intent.getSerializableExtra("product") as Product

        binding.edtProductName.setText(product.title)
        binding.edtProductOrigin.setText(product.origin)
        binding.edtProductPrice.setText(product.price)

        binding.btnAddProduct.setOnClickListener {
            val title = binding.edtProductName.text.toString()
            val origin = binding.edtProductOrigin.text.toString()
            val price = binding.edtProductPrice.text.toString()
            viewModel.updateProduct(Product(product.id, title, origin, price))
            finish()
        }

    }
}