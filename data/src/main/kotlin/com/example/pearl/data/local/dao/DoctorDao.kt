package com.example.pearl.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pearl.data.local.entity.DoctorEntity

@Dao
interface DoctorDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun addDoctorToFavorite(doctor: DoctorEntity)

    @Delete
     suspend fun removeDoctorFromFavorite(doctor: DoctorEntity)

    @Query("SELECT * FROM doctor")
    suspend fun getDoctors() : List<DoctorEntity>

}
