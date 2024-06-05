package com.example.pearl.presentation.products

import androidx.annotation.DrawableRes
import com.example.pearl.R

sealed class ProductType(
    @DrawableRes val icon : Int,
    val name : String
){
    object Cleanser : ProductType(
        icon = R.drawable.cleanser_product_icon,
        name = "Cleanser"
    )

    object Moisturizer : ProductType(
        icon = R.drawable.cream_product_icon,
        name = "Moisturizer"
    )

    object Serum : ProductType(
        icon = R.drawable.serum_product_icon,
        name = "Serum"
    )

    object Toner : ProductType(
        icon = R.drawable.toner_product_icon,
        name = "Toner"
    )

    object SunScreen : ProductType(
        icon = R.drawable.sun_screen_product_icon,
        name = "Sun Screen"
    )

    object SheetMask : ProductType(
        icon = R.drawable.facemask_icon,
        name = "Sheet Mask"
    )

    object EyeCare : ProductType(
        icon = R.drawable.eye_product_icon,
        name = "Eye Care"
    )

    object LipCare :ProductType(
        icon = R.drawable.lips_product_icon,
        name = "Lip Care"
    )

    override fun toString(): String {
        return this.name
    }

}

val productTypes = listOf(
    ProductType.Cleanser,
    ProductType.Moisturizer,
    ProductType.Serum,
    ProductType.Toner,
    ProductType.SunScreen,
    ProductType.SheetMask,
    ProductType.EyeCare,
    ProductType.LipCare,
)