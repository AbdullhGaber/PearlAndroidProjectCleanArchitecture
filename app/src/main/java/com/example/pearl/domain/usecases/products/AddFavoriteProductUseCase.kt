package com.example.pearl.domain.usecases.products

import com.example.pearl.domain.model.Product
import com.example.pearl.domain.repositories.ProductsRepository

class AddFavoriteProductUseCase(
    val productsRepository: ProductsRepository
) {
    suspend operator fun invoke(
        product : Product,
        onFailure: (Throwable) -> Unit
    ){
        productsRepository.addProductToFavorite(product , onFailure)
    }
}