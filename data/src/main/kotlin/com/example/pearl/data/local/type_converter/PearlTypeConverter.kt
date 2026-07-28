package com.example.pearl.data.local.type_converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class PearlTypeConverter {
    @TypeConverter
    fun fromString(ingredients: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(ingredients, listType)
    }

    @TypeConverter
    fun fromList(ingredients: List<String>): String {
        return Gson().toJson(ingredients)
    }

    @TypeConverter
    fun fromAppointmentTime(value: String): List<List<String>> {
        val listType = object : TypeToken<List<List<String>>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toAppointmentTime(list: List<List<String>>): String {
        return Gson().toJson(list)
    }
}
