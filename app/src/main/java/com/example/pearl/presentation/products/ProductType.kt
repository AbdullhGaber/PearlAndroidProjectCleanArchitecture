package com.example.pearl.presentation.products

import com.example.pearl.R



data class ProductType(val name : String = "", val icon: Int = 0){
     companion object{
        const val CLEANSER = "Cleanser"
        const val MOISTURIZER = "Moisturizer"
        const val SERUM = "Serum"
        const val TONER = "Toner"
        const val SUN_SCREEN = "SunScreen"
        const val SHEET_MASK = "SheetMask"
        const val EYE_CARE = "EyeCare"
        const val LIP_CARE = "LipCare"

        fun createCleanser() : ProductType {
            return ProductType(CLEANSER , R.drawable.cleanser_product_icon)
        }

        fun createMoisturizer() : ProductType {
            return ProductType(MOISTURIZER , R.drawable.cream_product_icon)
        }

        fun createSerum() : ProductType {
            return ProductType(SERUM , R.drawable.serum_product_icon)
        }
        fun createToner() : ProductType {
            return ProductType(TONER , R.drawable.toner_product_icon)
        }

        fun createSunScreen() : ProductType {
            return ProductType(SUN_SCREEN , R.drawable.sun_screen_product_icon)
        }

        fun createSheetMask() : ProductType {
            return ProductType(SHEET_MASK , R.drawable.facemask_icon)
        }

        fun createEyeCare() : ProductType {
            return ProductType(EYE_CARE , R.drawable.eye_product_icon)
        }

        fun createLipCare() : ProductType {
            return ProductType(LIP_CARE , R.drawable.lips_product_icon)
        }
    }
}

val productTypes = listOf(
    ProductType.createCleanser(),
    ProductType.createMoisturizer(),
    ProductType.createSerum(),
    ProductType.createToner(),
    ProductType.createSunScreen(),
    ProductType.createSheetMask(),
    ProductType.createEyeCare(),
    ProductType.createLipCare(),
)