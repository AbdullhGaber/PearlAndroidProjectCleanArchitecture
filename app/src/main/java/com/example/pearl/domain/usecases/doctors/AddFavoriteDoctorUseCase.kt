package com.example.pearl.domain.usecases.doctors

import com.example.pearl.domain.model.Doctor
import com.example.pearl.domain.repositories.DoctorRepository

class AddFavoriteDoctorUseCase(
    val doctorRepository: DoctorRepository
) {
    suspend operator fun invoke(doctor: Doctor, onFailure: (Throwable) -> Unit){
        doctorRepository.addDoctorToFavorite(doctor , onFailure)
    }
}