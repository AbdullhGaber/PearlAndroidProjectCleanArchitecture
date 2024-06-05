package com.example.pearl.presentation.common

import com.example.pearl.presentation.products.ProductType

fun getProductTypeFromString(productTypeName: String): ProductType {
    return when (productTypeName) {
        "Cleanser" -> ProductType.Cleanser
        "Moisturizer" -> ProductType.Moisturizer
        "Serum" -> ProductType.Serum
        "Toner" -> ProductType.Toner
        "Sun Screen" -> ProductType.SunScreen
        "Sheet Mask" -> ProductType.SheetMask
        "Eye Care" -> ProductType.EyeCare
        "Lip Care" -> ProductType.LipCare
        else -> throw IllegalArgumentException("Unknown product type: $productTypeName")
    }
}