package com.example.pearl.domain.model

data class Doctor(
    val id: Int = -1,
    val uid: String = "",
    val name: String = "",
    val age: String = "",
    val image: String = "",
    val imageInt: Int = 0,
    val location: String = "",
    val rate: String = "",
    val experience: Int = 0,
    val description: String = "",
    val reviewsNo: Int = 0,
    val appointmentTime: List<List<String>> = emptyList(),
    val onlineAppointmentPrice: Double = 0.0,
    val inPersonAppointmentPrice: Double = 0.0,
    var isFavorite: Boolean = false
)
