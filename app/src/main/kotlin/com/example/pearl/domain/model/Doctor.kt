package com.example.pearl.domain.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pearl.R

@Entity
data class Doctor(
    @PrimaryKey
    val id : Int = -1,
    val uid : String = "",
    val name : String = "",
    val age : String = "",
    val image : String = "",
    val imageInt : Int = 0,
    val location : String = "",
    val rate : String = "",
    val experience : Int = 0,
    val description : String = "",
    val reviewsNo: Int = 0,
    val appointmentTime : List<List<String>> = emptyList(),
    val onlineAppointmentPrice : Double = 0.0,
    val inPersonAppointmentPrice : Double = 0.0,
    var isFavorite : Boolean = false
)

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
