package com.example.pearl.presentation.dermatologists

import com.example.pearl.domain.model.Doctor

sealed class DoctorEvents {
    data class AddRemoveFavoriteDoctor(val doctor : Doctor) : DoctorEvents()
    data class ObserveOnDoctorList(val doctors : List<Doctor>) : DoctorEvents()
}