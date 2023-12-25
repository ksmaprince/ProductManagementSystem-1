package com.demo.productmanagementsystem.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.productmanagementsystem.data.Product
import com.demo.productmanagementsystem.databinding.ActivityAddProductBinding
import com.demo.productmanagementsystem.viewmodel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AddProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddProductBinding
    @Inject lateinit var viewModel: ProductViewModel

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, AddProductActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddProduct.setOnClickListener {
            val name = binding.edtProductName.text.toString()
            val origin = binding.edtProductOrigin.text.toString()
            val price = binding.edtProductPrice.text.toString()

            viewModel.saveProduct(Product(0, name, origin, price))
            finish()
        }

    }
}