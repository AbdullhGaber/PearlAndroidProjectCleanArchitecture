package com.example.pearl.presentation.community

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class AdCardData(
    @DrawableRes val profileImage : Int = R.drawable.profile_placeholder,
    val profileUserName : String,
    val image : Int,
    val body : String,
    val likesNo : Int = 0,
    val commentsNo : Int = 0
)

val adPosts = mutableListOf(
    AdCardData(
        profileImage = R.drawable.ad_profile_image,
        profileUserName = "BronteGlow",
        image = R.drawable.ad_image,
        body = "Unlock a new level of beauty with BronteGlow! Our serum, enriched with Vitamin C and plant extracts, delivers firmness and luminosity. Order now for a radiant transformation!",
        likesNo = 127,
        commentsNo = 24
    ),
)