package com.example.pearl.presentation.book_appointment

import com.example.pearl.domain.model.Doctor

data class BookAppointmentState(
    var doctor : Doctor = Doctor(),
    val showErrorDialog : Boolean = false,
    val error : Throwable? = null
)
