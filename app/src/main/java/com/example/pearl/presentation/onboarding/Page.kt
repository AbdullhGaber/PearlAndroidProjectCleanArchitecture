package com.example.pearl.presentation.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.ui.res.painterResource
import com.example.pearl.R

data class Page(
    @DrawableRes val personImage : Int ,
    @DrawableRes val sunMoonImage : Int? = null,
    val title : String ,
    val text : String
)

val pages = listOf(
    Page(
        personImage = R.drawable.onboarding_picture_1,
        title = "Analise your skin and know its type",
        text = "Lorem ipsum dolor sit amet consectetur. Vestibulum nam sed platea bibendum libero tempor faucibus."
    ),

    Page(
        personImage = R.drawable.onboarding_picture_2,
        sunMoonImage = R.drawable.sun,
        title = "Get your morning skin routine",
        text = "Lorem ipsum dolor sit amet consectetur. Vestibulum nam sed platea bibendum libero tempor faucibus."
    ),

    Page(
        personImage = R.drawable.onboarding_picture_3,
        sunMoonImage = R.drawable.moon,
        title = "And your night skin routine",
        text = "Lorem ipsum dolor sit amet consectetur. Vestibulum nam sed platea bibendum libero tempor faucibus."
    ),
)