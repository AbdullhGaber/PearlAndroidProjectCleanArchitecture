package com.example.pearl.domain.model

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pearl.R
@Entity
data class Doctor(
    @PrimaryKey
    val id : Int = -1,
    val name : String = "",
    @DrawableRes
    val image : Int = 0,
    val location : String = "",
    val rate : String = "",
    val experience : Int = 0,
    val description : String = "",
    val reviewsNo: Int = 0,
    var isFavorite : Boolean = false
)

val doctors = listOf(
    Doctor(
        image = R.drawable.doctor_1,
        name = "Dr. Mariam Zahran",
        location = "El-Mansoura",
        rate = "4.8",
        experience = 7,
        description = "Dr. Mariam, an accomplished dermatologist rs of specialized experience, excels in diagnosing"
    ),

    Doctor(
        image = R.drawable.doctor_4,
        name = "Dr. Nadia Emara",
        location = "El-Mansoura",
        rate = "4.7",
        experience = 13
    ),

    Doctor(
        image = R.drawable.doctor_3,
        name = "Dr. Ahmed Khaled",
        location = "El-Mansoura",
        rate = "4.7",
        experience = 8
    ),

    Doctor(
        image = R.drawable.doctor_2,
        name = "Dr. Salma Karam",
        location = "El-Mansoura",
        rate = "4.5",
        experience = 5
    ),
)