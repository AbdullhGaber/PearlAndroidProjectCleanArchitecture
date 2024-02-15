package com.example.pearl.presentation.dermatologists

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class DermatologistDetailsIconsData(
    @DrawableRes val icon : Int,
    val number : Number,
    val text : String
)

val dermatologistDetailsIcon = listOf(
    DermatologistDetailsIconsData(
        icon = R.drawable.bag_experience,
        number = 7,
        text = "Exp Years"
    ),

    DermatologistDetailsIconsData(
        icon = R.drawable.doctor_details_rating_star,
        number = 4.8,
        text = "Rating"
    ),

    DermatologistDetailsIconsData(
        icon = R.drawable.doctor_details_reviews,
        number = 143,
        text = "Reviews"
    ),
)