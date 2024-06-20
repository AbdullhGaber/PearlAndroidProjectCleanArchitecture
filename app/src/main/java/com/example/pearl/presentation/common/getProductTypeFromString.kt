package com.example.pearl.presentation.common

import com.example.pearl.presentation.products.ProductType

fun getProductTypeFromString(productTypeName: String): ProductType {
    return when (productTypeName) {
        ProductType.CLEANSER -> ProductType.createCleanser()
        ProductType.MOISTURIZER -> ProductType.createMoisturizer()
        ProductType.SERUM -> ProductType.createSerum()
        ProductType.TONER -> ProductType.createToner()
        ProductType.SUN_SCREEN -> ProductType.createSunScreen()
        ProductType.SHEET_MASK -> ProductType.createSheetMask()
        ProductType.EYE_CARE -> ProductType.createEyeCare()
        ProductType.LIP_CARE -> ProductType.createLipCare()
        else -> throw IllegalArgumentException("Unknown product type: $productTypeName")
    }
}