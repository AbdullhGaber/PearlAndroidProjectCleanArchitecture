package com.example.pearl.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pearl.domain.model.Doctor

@Dao
interface DoctorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun addDoctorToFavorite(doctor: Doctor)

    @Delete
     suspend fun removeDoctorFromFavorite(doctor: Doctor)

    @Query("SELECT * FROM doctor")
    suspend fun getDoctors() : List<Doctor>

}