package com.example.pearl.presentation.book_appointment

sealed class BookAppointmentEvents {
    data class GetDoctorDetails(val doctorUid : String, ) : BookAppointmentEvents()

    data class ShowErrorDialog(val error:Throwable?) : BookAppointmentEvents()

    object HideErrorDialog : BookAppointmentEvents()
}
