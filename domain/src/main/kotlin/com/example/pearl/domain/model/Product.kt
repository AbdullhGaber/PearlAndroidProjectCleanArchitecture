package com.example.pearl.domain.model

data class Product(
    val id: Int = -1,
    val name: String = "",
    val image: Int = 0,
    val description: String = "",
    val ingredients: List<String> = emptyList(),
    val productType: String = "",
    val shouldAvoid: Boolean = false,
    var isFavorite: Boolean = false
)
