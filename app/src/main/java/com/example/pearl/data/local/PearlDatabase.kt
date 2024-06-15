package com.example.pearl.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pearl.domain.model.Product
import com.example.pearl.domain.model.Routine

//@Database(entities = [Routine::class , Product::class], version = 1)
abstract class PearlDatabase : RoomDatabase() {

}