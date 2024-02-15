package com.example.pearl.presentation.dermatologists

import androidx.annotation.DrawableRes
import com.example.pearl.R

data class DermatologistScheduleCardData(
    val date : String,
    val doctorName : String,
    @DrawableRes val image : Int,
    val location : String,
    val bookingID : String
)

val dermatologistsSchedule = listOf(
    DermatologistScheduleCardData(
        date = "Aug 25, 2023 - 10:00 AM",
        doctorName = "Sandy Samed",
        image = R.drawable.doctor_5,
        location = "El Mansoura, El Gaish St",
        bookingID = "#5763542"
    ),

    DermatologistScheduleCardData(
        date = "Aug 25, 2023 - 10:00 AM",
        doctorName = "Mariam Zahran",
        image = R.drawable.doctor_1,
        location = "El Mansoura, El Gaish St",
        bookingID = "#5763542"
    ),
)