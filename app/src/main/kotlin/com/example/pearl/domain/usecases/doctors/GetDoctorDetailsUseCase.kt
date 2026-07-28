package com.example.pearl.domain.usecases.doctors

import com.example.pearl.domain.model.Doctor
import com.example.pearl.domain.repositories.DoctorRepository

class GetDoctorDetailsUseCase(
    val doctorRepository: DoctorRepository
) {

    suspend operator fun invoke(
        doctorUid : String,
        onSuccess : (Doctor) -> Unit,
        onFailure : (Throwable) -> Unit
    ){
        doctorRepository.getDoctor(doctorUid , onSuccess, onFailure)
    }
}
