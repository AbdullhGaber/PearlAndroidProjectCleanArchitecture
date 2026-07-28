package com.example.pearl.presentation.dermatologists

import com.example.pearl.domain.model.Doctor

data class DoctorScreenState(
    val doctors : List<Doctor> = nearestDermatologistsCardData,
    val favoriteDoctors : List<Doctor> = emptyList()
)
