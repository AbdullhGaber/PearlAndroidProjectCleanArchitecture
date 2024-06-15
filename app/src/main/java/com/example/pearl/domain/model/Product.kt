package com.example.pearl.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pearl.presentation.products.ProductType


data class Product(
    val id : Int = -1,
    val name : String = "",
    val image : Int = 0,
    val description : String = "",
    val ingredients : List<String> = emptyList(),
    val productType : ProductType = ProductType.createCleanser(),
    val shouldAvoid : Boolean = false,
    val isFavorite : Boolean = false
)
