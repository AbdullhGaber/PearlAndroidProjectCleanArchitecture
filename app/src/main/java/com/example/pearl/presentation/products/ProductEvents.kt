package com.example.pearl.presentation.products

import com.example.pearl.domain.model.Product

sealed class ProductEvents {
    data class AddRemoveFavoriteProduct(val product : Product) : ProductEvents()

    data class ObserveOnProductList(val product: List<Product>) : ProductEvents()
}