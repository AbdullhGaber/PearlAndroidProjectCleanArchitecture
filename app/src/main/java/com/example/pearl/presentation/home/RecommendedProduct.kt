package com.example.pearl.presentation.home


import com.example.pearl.R
import com.example.pearl.domain.model.Product
import com.example.pearl.presentation.products.ProductType


val recommendedProducts = listOf(
    Product(
        id = 1,
        image = R.drawable.vitamine_c,
        name = "Dr.Rashel Vitamin C Face Serum",
        productType = ProductType.createSerum(),

    ),

    Product(
        id = 2,
        image = R.drawable.bluebell,
        name = "BLUEBELL Malinda AHA/BHA Gel",
        productType = ProductType.createCleanser()
    ),

    Product(
        id = 3,
        image = R.drawable.eucerin,
        name = "Eucerin Dermopurifyer Cleansing Gel",
        productType = ProductType.createCleanser()
    ),

    Product(
        id = 4,
        image = R.drawable.care_and_more,
        name = "Care & More Soft cream with glycerin",
        productType = ProductType.createMoisturizer()
    ),

    Product(
        id = 5,
        image = R.drawable.vitamine_c,
        name = "Dr.Rashel Vitamin C Face Serum",
        productType = ProductType.createSerum()
    ),

    Product(
        id = 6,
        image = R.drawable.bluebell,
        name = "BLUEBELL Malinda AHA/BHA Gel",
        productType = ProductType.createCleanser()
    ),

    Product(
        id = 6,
        image = R.drawable.eucerin,
        name = "Eucerin Dermopurifyer Cleansing Gel",
        productType = ProductType.createCleanser()
    ),

    Product(
        id = 7,
        image = R.drawable.care_and_more,
        name = "Care & More Soft cream with glycerin",
        productType = ProductType.createMoisturizer()
    ),
)

