package com.example.pearl.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pearl.data.local.dao.DoctorDao
import com.example.pearl.data.local.dao.ProductDao
import com.example.pearl.data.local.type_converter.PearlTypeConverter
import com.example.pearl.data.local.entity.DoctorEntity
import com.example.pearl.data.local.entity.ProductEntity

@Database(entities = [DoctorEntity::class , ProductEntity::class], version = 1)
@TypeConverters(PearlTypeConverter::class)
abstract class PearlDatabase : RoomDatabase() {
    abstract val doctorDao : DoctorDao
    abstract val productDao : ProductDao
}
