package com.dev.olutoba.xmodern_android.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.dev.olutoba.xmodern_android.R
import com.dev.olutoba.xmodern_android.databinding.ItemProductBinding
import com.dev.olutoba.xmodern_android.model.Product


/**
 * Created by Onikoyi Damola Olutoba
 * DATE: 13 October, 2024
 * EMAIL: damexxey94@gmail.com
 */

class ProductsAdapter :
    ListAdapter<Product, ProductsAdapter.ProductsViewHolder>(ProductsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ProductsViewHolder(ItemProductBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ProductsViewHolder(
        private val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.imageProduct.load(product.thumbnail)
            binding.textTitle.text =
                binding.root.context.getString(
                    R.string.product_title_price, product.title, product.price.toString()
                )
            binding.textDescription.text = product.description
        }
    }
}

private class ProductsDiffUtil : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}