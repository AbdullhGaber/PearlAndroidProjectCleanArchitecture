package com.example.pearl.presentation.dermatologists

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class DermatologistCardData(
    val name : String,
    @DrawableRes val image : Int,
    val rate : String,
    val location : String,
    val experience : Int,
    val reviewsNo: Int,
    val isFavorite : Boolean = false
)

val nearestDermatologistsCardData = listOf(
    DermatologistCardData(
        name = "Mariam Zahran",
        image = R.drawable.doctor_1,
        rate = "4.8",
        location = "El Mansoura",
        experience = 7,
        reviewsNo = 143,
    ),

    DermatologistCardData(
        name = "Nadia Emara",
        image = R.drawable.doctor_4,
        rate = "4.7",
        location = "El Mansoura",
        experience = 13,
        reviewsNo = 128
    ),

    DermatologistCardData(
        name = "Ahmed Khaled",
        image = R.drawable.doctor_3,
        rate = "4.7",
        location = "El Mansoura",
        experience = 8,
        reviewsNo = 142
    ),
)

val favoriteDermatologistsCardData = listOf(
    DermatologistCardData(
        name = "Mariam Zahran",
        image = R.drawable.doctor_1,
        rate = "4.8",
        location = "El Mansoura",
        experience = 7,
        reviewsNo = 143,
        isFavorite = true
    ),

    DermatologistCardData(
        name = "Nadia Emara",
        image = R.drawable.doctor_4,
        rate = "4.7",
        location = "El Mansoura",
        experience = 13,
        reviewsNo = 128,
        isFavorite = true
    ),

    DermatologistCardData(
        name = "Ahmed Khaled",
        image = R.drawable.doctor_3,
        rate = "4.7",
        location = "El Mansoura",
        experience = 8,
        reviewsNo = 142,
        isFavorite = true
    ),
)

