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
        title = "Unlock Your Skin's Secrets",
        text = "Explore your skin with our easy skin scan. Find out your skin type and get personalized tips."
    ),

    Page(
        personImage = R.drawable.onboarding_picture_4,
        title = "Customized Care, Just for You",
        text = "Discover personalized product suggestions and tips crafted for your unique skin. Elevate your skincare journey with individualized care."
    ),

    Page(
        personImage = R.drawable.onboarding_picture_2,
        title = "Get your morning skin routine",
        text = "Start your day with a refreshing morning routine designed to nourish and revitalize your skin. Embrace the glow and set the tone for a beautiful day ahead"
    ),

    Page(
        personImage = R.drawable.onboarding_picture_3,
        sunMoonImage = R.drawable.moon,
        title = "And your night skin routine",
        text = "Nourish your skin with a simple night routine. Let it restore and refresh while you sleep, so you wake up to a rejuvenated and glowing complexion."
    ),
)