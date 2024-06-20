package com.example.pearl.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pearl.data.local.dao.DoctorDao
import com.example.pearl.data.local.dao.ProductDao
import com.example.pearl.data.local.type_converter.PearlTypeConverter
import com.example.pearl.domain.model.Doctor
import com.example.pearl.domain.model.Product
import com.example.pearl.domain.model.Routine

@Database(entities = [Doctor::class , Product::class], version = 1)
@TypeConverters(PearlTypeConverter::class)
abstract class PearlDatabase : RoomDatabase() {
    abstract val doctorDao : DoctorDao
    abstract val productDao : ProductDao
}