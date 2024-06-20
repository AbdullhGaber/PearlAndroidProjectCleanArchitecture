package com.example.pearl.domain.usecases.products

import com.example.pearl.domain.model.Product
import com.example.pearl.domain.repositories.ProductsRepository

class GetFavoriteProductsUseCase(
    val productsRepository: ProductsRepository
) {
    suspend operator fun invoke(
        onSuccess : (List<Product>) -> Unit,
        onFailure : (Throwable) -> Unit
    ) : List<Product>{
        return productsRepository.getProducts(onSuccess,onFailure)
    }
}