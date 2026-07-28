package com.example.pearl.presentation.common

import com.example.pearl.domain.model.Doctor
import com.example.pearl.design_system.R

val doctors = listOf(
    Doctor(
        imageInt = R.drawable.female_doctor_1,
        onlineAppointmentPrice = 150.0,
        inPersonAppointmentPrice = 200.0,
        name = "Dr. Mariam Zahran",
        location = "El-Mansoura",
        rate = "4.8",
        experience = 7,
        description = "Dr. Mariam, an accomplished dermatologist rs of specialized experience, excels in diagnosing"
    ),

    Doctor(
        name = "Dr. Nadia Emara",
        imageInt = R.drawable.female_doctor_2,
        location = "El-Mansoura",
        rate = "4.7",
        experience = 13
    ),

    Doctor(
        uid = "URfZ2Dz6cebkr36b1qh4ruYfU4n1",
        name = "Dr. Abdullh Gaber",
        location = "El-Mansoura",
        imageInt = R.drawable.doctor_3,
        rate = "4.7",
        experience = 8
    ),

    Doctor(
        name = "Dr. Salma Karam",
        imageInt = R.drawable.female_doctor_2,
        location = "El-Mansoura",
        rate = "4.5",
        experience = 5
    ),
)
