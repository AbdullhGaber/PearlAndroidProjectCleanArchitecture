package com.example.pearl.presentation.products

import com.example.pearl.domain.model.Product

data class ProductScreenState(
    val products : List<Product> = featuredProducts
)