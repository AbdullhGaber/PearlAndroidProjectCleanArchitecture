package com.example.pearl.presentation.products


import com.example.pearl.R
import com.example.pearl.domain.model.Product


val featuredProducts = listOf(
    Product(
        id = 1,
        image = R.drawable.ciel_cleanser,
        name = "CIEL",
        productType = ProductType.createCleanser(),
        description = "Vitamin C Face Serum",
    ),

    Product(
        id = 2,
        image = R.drawable.cera_ve_cleanser,
        name = "CeraVe",
        productType = ProductType.createCleanser(),
        description = "Cleanser for Oily, Combined and Acne Prone Skin",
    ),

    Product(
        id = 3,
        image = R.drawable.eucerin,
        name = "Eucerin",
        productType = ProductType.createCleanser(),
        description = "Dermopurifyer Cleansing Gel",
    ),

    Product(
        id = 4,
        image = R.drawable.bluebell,
        name = "BLUEBELL Malinda",
        productType = ProductType.createCleanser(),
        description = "Gel AHA / BHA Cleanser"
    ),

    Product(
        id = 5,
        image = R.drawable.shaan_gel_cleanser,
        name = "Shaan 1",
        productType = ProductType.createCleanser(),
        description = "Facial cleanser antioxidant"
    ),

    Product(
        id = 6,
        image = R.drawable.starville_cleanser,
        name = "Starville",
        productType = ProductType.createCleanser(),
        description = "Acne prone skin cleanser"
    ),

    Product(
        id = 7,
        image = R.drawable.shaan_moisturizer,
        name = "Shaan 2",
        productType = ProductType.createMoisturizer(),
        description = "Soothing Gel with vitamin E",
    ),

    Product(
        id = 8,
        image = R.drawable.shaan_moisturizer,
        name = "Shaan 3",
        productType = ProductType.createMoisturizer(),
        description = "Soothing Gel with vitamin E",
    ),

    Product(
        id = 9,
        image = R.drawable.hayah_moisturizer,
        name = "HAYAH",
        productType = ProductType.createMoisturizer(),
        description = "Sebaclar hydra acne cream"
    ),

    Product(
        id = 10,
        image = R.drawable.hayah_moisturizer,
        name = "Cleo",
        productType = ProductType.createMoisturizer(),
        description = "Ultra Rich Moisturizer",
    ),

    Product(
        id = 11,
        image = R.drawable.stives_moisturizer,
        name = "Stives",
        productType = ProductType.createMoisturizer(),
        description = "Facial moisturizer with Collagen & Elastin",
    ),

    Product(
        id = 12,
        image = R.drawable.cera_ve_moisturizer,
        name = "Stives",
        productType = ProductType.createMoisturizer(),
        description = "Moisturising Lotion SPF25",
    ),

    Product(
        id = 13,
        image = R.drawable.shaan_moisturizer,
        name = "Shaan 4",
        productType = ProductType.createMoisturizer(),
        description = "Soothing Gel with vitamin E"
    ),
)