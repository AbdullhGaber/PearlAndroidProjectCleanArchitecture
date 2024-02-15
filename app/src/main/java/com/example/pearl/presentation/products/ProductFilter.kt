package com.example.pearl.presentation.products

import androidx.annotation.DrawableRes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.pearl.R

data class ProductFilter(
    @DrawableRes val icon : Int ,
    val name : String,
    val size : Dp = 38.dp
)

val productFilters = listOf(
    ProductFilter(
     icon = R.drawable.for_you_icon,
     name = "For You"
    ),

    ProductFilter(
     icon = R.drawable.skin_type_icon,
     name = "Skin Type"
    ),

    ProductFilter(
     icon = R.drawable.ingredients_icon,
     name = "Ingredients",
     size = 38.dp
    ),

    ProductFilter(
     icon = R.drawable.price_icon,
     name = "Price",
     size = 32.dp
    )
)