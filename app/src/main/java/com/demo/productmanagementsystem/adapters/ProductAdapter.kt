package com.demo.productmanagementsystem.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.demo.productmanagementsystem.data.Product
import com.demo.productmanagementsystem.databinding.ListItemBinding
import javax.inject.Inject

class ProductAdapter @Inject constructor(): Adapter<ProductAdapter.ProductViewHolder>() {
    var products: List<Product> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    private lateinit var imageClickListener: OnImageClickListener
    private lateinit var iconDeleteClickListener: OnIconDeleteClickListener

    fun setOnImageClickListener(listener: OnImageClickListener) {
        this.imageClickListener = listener
    }

    fun setOnIconDeleteClickListener(listener: OnIconDeleteClickListener){
        this.iconDeleteClickListener = listener
    }

    interface OnImageClickListener {
        fun onImageClick(product: Product)
    }

    interface OnIconDeleteClickListener{
        fun onDeleteIconClick(product: Product)
    }

    inner class ProductViewHolder(val binding: ListItemBinding) : ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.tvProductName.text = product.title
            binding.tvProductOrigin.text = product.origin
            binding.tvProductPrice.text = product.price
            binding.ivIcon.setOnClickListener {
                if (imageClickListener != null && adapterPosition != RecyclerView.NO_POSITION) {
                    imageClickListener.onImageClick(product)
                }
            }
            binding.ivDelete.setOnClickListener {
                if (iconDeleteClickListener != null && adapterPosition != RecyclerView.NO_POSITION){
                    iconDeleteClickListener.onDeleteIconClick(product)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int = products.size


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }


}