package com.example.pearl.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pearl.domain.model.Product

@Entity(tableName = "Product")
data class ProductEntity(
    @PrimaryKey
    val id: Int = -1,
    val name: String = "",
    val image: Int = 0,
    val description: String = "",
    val ingredients: List<String> = emptyList(),
    val productType: String = "",
    val shouldAvoid: Boolean = false,
    var isFavorite: Boolean = false
)

fun ProductEntity.toDomain(): Product = Product(
    id = id,
    name = name,
    image = image,
    description = description,
    ingredients = ingredients,
    productType = productType,
    shouldAvoid = shouldAvoid,
    isFavorite = isFavorite
)

fun Product.toEntity(): ProductEntity = ProductEntity(
    id = id,
    name = name,
    image = image,
    description = description,
    ingredients = ingredients,
    productType = productType,
    shouldAvoid = shouldAvoid,
    isFavorite = isFavorite
)
