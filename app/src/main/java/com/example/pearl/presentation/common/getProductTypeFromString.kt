package com.example.pearl.presentation.common

import com.example.pearl.presentation.products.ProductType

fun getProductTypeFromString(productTypeName: String): ProductType {
    return when (productTypeName) {
        "Cleanser" -> ProductType.createCleanser()
        "Moisturizer" -> ProductType.createMoisturizer()
        "Serum" -> ProductType.createSerum()
        "Toner" -> ProductType.createToner()
        "Sun Screen" -> ProductType.createSunScreen()
        "Sheet Mask" -> ProductType.createSheetMask()
        "Eye Care" -> ProductType.createEyeCare()
        "Lip Care" -> ProductType.createLipCare()
        else -> throw IllegalArgumentException("Unknown product type: $productTypeName")
    }
}