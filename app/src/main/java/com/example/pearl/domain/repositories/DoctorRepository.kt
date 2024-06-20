package com.example.pearl.domain.repositories

import com.example.pearl.domain.model.Doctor

interface DoctorRepository {

    suspend fun addDoctorToFavorite(doctor: Doctor , onFailure: (Throwable) -> Unit)

    suspend fun removeDoctorFromFavorite(doctor: Doctor , onFailure: (Throwable) -> Unit)

    suspend fun getFavoriteDoctors(
        onSuccess : (List<Doctor>) -> Unit,
        onFailure : (Throwable) -> Unit
    ) : List<Doctor>
}