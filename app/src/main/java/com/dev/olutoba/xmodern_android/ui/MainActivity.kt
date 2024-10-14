package com.dev.olutoba.xmodern_android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.dev.olutoba.xmodern_android.adapters.ProductsAdapter
import com.dev.olutoba.xmodern_android.data.datasource.remote.ProductRemoteDataSource
import com.dev.olutoba.xmodern_android.data.repository.ProductRepositoryImpl
import com.dev.olutoba.xmodern_android.databinding.ActivityMainBinding
import com.dev.olutoba.xmodern_android.viewmodel.ProductViewModelFactory
import com.dev.olutoba.xmodern_android.viewmodel.ProductsViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductsAdapter
    private lateinit var viewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productRemoteDataSource = ProductRemoteDataSource()
        val productRepository = ProductRepositoryImpl(productRemoteDataSource)

        viewModel = ViewModelProvider(
            this,
            ProductViewModelFactory(productRepository)
        )[ProductsViewModel::class.java]

        adapter = ProductsAdapter()
        binding.recyclerviewProducts.adapter = adapter

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    binding.progressCircular.isVisible = it.isLoading
                    adapter.submitList(it.products)
                }
            }
        }
    }
}