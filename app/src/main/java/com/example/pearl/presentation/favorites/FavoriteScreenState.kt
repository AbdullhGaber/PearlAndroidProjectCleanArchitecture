package com.example.pearl.presentation.favorites

import com.example.pearl.domain.model.Doctor
import com.example.pearl.domain.model.Product

data class FavoriteScreenState(
    val favoriteDoctors : List<Doctor> = emptyList(),
    val favoriteProducts : List<Product> = emptyList(),
    val error : String? = "",
    val isErrorShown : Boolean = false
)
