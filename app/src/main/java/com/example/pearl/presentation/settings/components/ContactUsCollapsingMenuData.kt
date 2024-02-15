package com.example.pearl.presentation.settings.components

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class ContactUsCollapsingMenuData(
    @DrawableRes val icon : Int,
    val title : String
)


val contactUsCollapsingMenuDataList = listOf(
    ContactUsCollapsingMenuData(
        icon = R.drawable.customer_service,
        title = "Customer Service"
    ),

    ContactUsCollapsingMenuData(
        icon = R.drawable.whatsapp,
        title = "Whatsapp"
    ),

    ContactUsCollapsingMenuData(
        icon = R.drawable.website,
        title = "Website"
    ),

    ContactUsCollapsingMenuData(
        icon = R.drawable.facebook,
        title = "Facebook"
    ),

    ContactUsCollapsingMenuData(
        icon = R.drawable.instagram,
        title = "Instagram"
    ),
)