package com.example.pearl.domain.usecases.doctors

import com.example.pearl.domain.model.Doctor
import com.example.pearl.domain.repositories.DoctorRepository

class GetFavoriteDoctorsUseCase(
    val doctorRepository: DoctorRepository
){
    suspend operator fun invoke(
        onSuccess : (List<Doctor>) -> Unit,
        onFailure : (Throwable) -> Unit
    ) : List<Doctor>{
        return doctorRepository.getFavoriteDoctors(onSuccess , onFailure)
    }
}