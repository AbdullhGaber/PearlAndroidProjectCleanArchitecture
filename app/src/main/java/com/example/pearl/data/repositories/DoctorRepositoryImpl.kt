package com.example.pearl.data.repositories

import com.example.pearl.data.local.dao.DoctorDao
import com.example.pearl.domain.model.Doctor
import com.example.pearl.domain.repositories.DoctorRepository

class DoctorRepositoryImpl(
    val mDoctorDao : DoctorDao
) : DoctorRepository {
    override suspend fun addDoctorToFavorite(doctor: Doctor ,onFailure: (Throwable) -> Unit) {
        try{
            mDoctorDao.addDoctorToFavorite(doctor)
        }catch (ex : Exception){
            onFailure(ex)
        }
    }

    override suspend fun removeDoctorFromFavorite(doctor: Doctor , onFailure: (Throwable) -> Unit) {
       try {
           mDoctorDao.removeDoctorFromFavorite(doctor)
       }catch (ex : Exception){
           onFailure(ex)
       }
    }

    override suspend fun getFavoriteDoctors(
        onSuccess : (List<Doctor>) -> Unit,
        onFailure : (Throwable) -> Unit
    ): List<Doctor> {
        return try {
           val doctors = mDoctorDao.getDoctors()
           onSuccess(doctors)
           doctors
        }catch (ex : Exception){
            onFailure(ex)
            emptyList()
        }
    }
}