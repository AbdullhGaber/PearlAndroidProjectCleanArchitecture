package com.example.pearl.domain.repositories


import com.example.pearl.domain.model.Product

interface ProductsRepository {
    suspend fun addProductToFavorite(
        product: Product,
        onFailure: (Throwable) -> Unit
    )

    suspend fun removeProductFromFavorite(
        product: Product,
        onFailure: (Throwable) -> Unit
    )

    suspend fun getProducts(
        onSuccess : (List<Product>) -> Unit,
        onFailure : (Throwable) -> Unit
    ) : List<Product>
}