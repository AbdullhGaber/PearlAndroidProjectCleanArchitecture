package com.example.pearl.domain.usecases.products

class ProductUseCases(
    val getAllProductUseCase: GetFavoriteProductsUseCase,
    val addFavoriteProductUseCase: AddFavoriteProductUseCase,
    val removeProductFromFavoriteUseCase: RemoveProductFromFavoriteUseCase
) {
}