package com.example.pearl.presentation.home

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class Doctor(
    @DrawableRes val image : Int,
    val name : String,
    val location : String,
    val rate : String,
    val experience : String
)

val doctors = listOf(
    Doctor(
        image = R.drawable.doctor_1,
        name = "Dr. Mariam Zahran",
        location = "El-Mansoura",
        rate = "4.8",
        experience = "7 years"
    ),

    Doctor(
        image = R.drawable.doctor_4,
        name = "Dr. Nadia Emara",
        location = "El-Mansoura",
        rate = "4.7",
        experience = "13 years"
    ),

    Doctor(
        image = R.drawable.doctor_3,
        name = "Dr. Ahmed Khaled",
        location = "El-Mansoura",
        rate = "4.7",
        experience = "8 years"
    ),

    Doctor(
        image = R.drawable.doctor_2,
        name = "Dr. Salma Karam",
        location = "El-Mansoura",
        rate = "4.5",
        experience = "5 years"
    ),
)