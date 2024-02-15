package com.example.pearl.presentation.home

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class RecommendedProduct(
    @DrawableRes val image : Int,
    val name : String,
    val type : String
)

val recommendedProducts = listOf(
    RecommendedProduct(
        image = R.drawable.vitamine_c,
        name = "Dr.Rashel Vitamin C Face Serum",
        type = "Serum"
    ),

    RecommendedProduct(
        image = R.drawable.bluebell,
        name = "BLUEBELL Malinda AHA/BHA Gel",
        type = "Cleanser"
    ),

    RecommendedProduct(
        image = R.drawable.eucerin,
        name = "Eucerin Dermopurifyer Cleansing Gel",
        type = "Cleanser"
    ),

    RecommendedProduct(
        image = R.drawable.care_and_more,
        name = "Care & More Soft cream with glycerin",
        type = "Moisturizer"
    ),

    RecommendedProduct(
        image = R.drawable.vitamine_c,
        name = "Dr.Rashel Vitamin C Face Serum",
        type = "Serum"
    ),

    RecommendedProduct(
        image = R.drawable.bluebell,
        name = "BLUEBELL Malinda AHA/BHA Gel",
        type = "Cleanser"
    ),

    RecommendedProduct(
        image = R.drawable.eucerin,
        name = "Eucerin Dermopurifyer Cleansing Gel",
        type = "Cleanser"
    ),

    RecommendedProduct(
        image = R.drawable.care_and_more,
        name = "Care & More Soft cream with glycerin",
        type = "Moisturizer"
    ),
)

