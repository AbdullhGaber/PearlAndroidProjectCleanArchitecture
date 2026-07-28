package com.example.pearl.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pearl.domain.model.Doctor

@Entity(tableName = "Doctor")
data class DoctorEntity(
    @PrimaryKey
    val id: Int = -1,
    val uid: String = "",
    val name: String = "",
    val age: String = "",
    val image: String = "",
    val imageInt: Int = 0,
    val location: String = "",
    val rate: String = "",
    val experience: Int = 0,
    val description: String = "",
    val reviewsNo: Int = 0,
    val appointmentTime: List<List<String>> = emptyList(),
    val onlineAppointmentPrice: Double = 0.0,
    val inPersonAppointmentPrice: Double = 0.0,
    var isFavorite: Boolean = false
)

fun DoctorEntity.toDomain(): Doctor = Doctor(
    id = id,
    uid = uid,
    name = name,
    age = age,
    image = image,
    imageInt = imageInt,
    location = location,
    rate = rate,
    experience = experience,
    description = description,
    reviewsNo = reviewsNo,
    appointmentTime = appointmentTime,
    onlineAppointmentPrice = onlineAppointmentPrice,
    inPersonAppointmentPrice = inPersonAppointmentPrice,
    isFavorite = isFavorite
)

fun Doctor.toEntity(): DoctorEntity = DoctorEntity(
    id = id,
    uid = uid,
    name = name,
    age = age,
    image = image,
    imageInt = imageInt,
    location = location,
    rate = rate,
    experience = experience,
    description = description,
    reviewsNo = reviewsNo,
    appointmentTime = appointmentTime,
    onlineAppointmentPrice = onlineAppointmentPrice,
    inPersonAppointmentPrice = inPersonAppointmentPrice,
    isFavorite = isFavorite
)
