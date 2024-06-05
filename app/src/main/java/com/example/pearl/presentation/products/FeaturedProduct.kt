package com.example.pearl.presentation.products

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class FeaturedProduct(
    @DrawableRes val image : Int,
    val name : String ,
    val type : ProductType,
    val description : String,
    val isFavorite : Boolean = false
)

val featuredProducts = listOf(

    FeaturedProduct(
        image = R.drawable.ciel_cleanser,
        name = "CIEL",
        type = ProductType.Cleanser,
        description = "Vitamin C Face Serum",
        isFavorite = true
    ),

    FeaturedProduct(
        image = R.drawable.cera_ve_cleanser,
        name = "CeraVe",
        type = ProductType.Cleanser,
        description = "Cleanser for Oily, Combined and Acne Prone Skin",
        isFavorite = true
    ),

    FeaturedProduct(
        image = R.drawable.eucerin,
        name = "Eucerin",
        type = ProductType.Cleanser,
        description = "Dermopurifyer Cleansing Gel",
        isFavorite = true
    ),

    FeaturedProduct(
        image = R.drawable.bluebell,
        name = "BLUEBELL Malinda",
        type = ProductType.Cleanser,
        description = "Gel AHA / BHA Cleanser"
    ),

    FeaturedProduct(
        image = R.drawable.shaan_gel_cleanser,
        name = "Shaan 1",
        type = ProductType.Cleanser,
        description = "Facial cleanser antioxidant"
    ),

    FeaturedProduct(
        image = R.drawable.starville_cleanser,
        name = "Starville",
        type = ProductType.Cleanser,
        description = "Acne prone skin cleanser"
    ),

    FeaturedProduct(
        image = R.drawable.shaan_moisturizer,
        name = "Shaan 2",
        type = ProductType.Moisturizer,
        description = "Soothing Gel with vitamin E",
        isFavorite = true
    ),

    FeaturedProduct(
        image = R.drawable.shaan_moisturizer,
        name = "Shaan 3",
        type = ProductType.Moisturizer,
        description = "Soothing Gel with vitamin E",
        isFavorite = true
    ),

    FeaturedProduct(
        image = R.drawable.hayah_moisturizer,
        name = "HAYAH",
        type = ProductType.Moisturizer,
        description = "Sebaclar hydra acne cream"
    ),

    FeaturedProduct(
        image = R.drawable.hayah_moisturizer,
        name = "Cleo",
        type = ProductType.Moisturizer,
        description = "Ultra Rich Moisturizer",
        isFavorite = true
    ),

    FeaturedProduct(
        image = R.drawable.stives_moisturizer,
        name = "Stives",
        type = ProductType.Moisturizer,
        description = "Facial moisturizer with Collagen & Elastin",
        isFavorite = true
    ),

    FeaturedProduct(
        image = R.drawable.cera_ve_moisturizer,
        name = "Stives",
        type = ProductType.Moisturizer,
        description = "Moisturising Lotion SPF25",
        isFavorite = true
    ),

    FeaturedProduct(
        image = R.drawable.shaan_moisturizer,
        name = "Shaan 4",
        type = ProductType.Moisturizer,
        description = "Soothing Gel with vitamin E"
    ),
)