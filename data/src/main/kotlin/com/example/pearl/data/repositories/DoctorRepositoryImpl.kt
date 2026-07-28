package com.example.pearl.data.repositories

import com.example.pearl.data.local.dao.DoctorDao
import com.example.pearl.data.local.entity.toDomain
import com.example.pearl.data.local.entity.toEntity
import com.example.pearl.domain.model.Doctor
import com.example.pearl.domain.repositories.DoctorRepository
import com.example.pearl.data.util.Constants
import com.google.firebase.database.FirebaseDatabase

class DoctorRepositoryImpl(
    val mDoctorDao : DoctorDao,
    val mDatabase: FirebaseDatabase
) : DoctorRepository {
    override suspend fun addDoctorToFavorite(doctor: Doctor ,onFailure: (Throwable) -> Unit) {
        try{
            mDoctorDao.addDoctorToFavorite(doctor.toEntity())
        }catch (ex : Exception){
            onFailure(ex)
        }
    }

    override suspend fun removeDoctorFromFavorite(doctor: Doctor , onFailure: (Throwable) -> Unit) {
       try {
           mDoctorDao.removeDoctorFromFavorite(doctor.toEntity())
       }catch (ex : Exception){
           onFailure(ex)
       }
    }

    override suspend fun getFavoriteDoctors(
        onSuccess : (List<Doctor>) -> Unit,
        onFailure : (Throwable) -> Unit
    ): List<Doctor> {
        return try {
           val doctors = mDoctorDao.getDoctors().map { it.toDomain() }
           onSuccess(doctors)
           doctors
        }catch (ex : Exception){
            onFailure(ex)
            emptyList()
        }
    }

    override suspend fun getDoctor(
        doctorUid : String,
        onSuccess: (Doctor) -> Unit,
        onFailure: (Throwable) -> Unit,
    ){
        val doctorRef = mDatabase.getReference(Constants.DOCTOR_REFERENCE).child(doctorUid)

        doctorRef.get().addOnCompleteListener {
            val doctor = it.result.getValue(Doctor::class.java)
            onSuccess(doctor!!)
        }.addOnFailureListener{
            onFailure(it)
        }
    }
}
