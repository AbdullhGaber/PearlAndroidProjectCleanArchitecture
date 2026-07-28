package com.example.pearl.presentation.book_appointment

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pearl.domain.model.Doctor
import com.example.pearl.domain.usecases.doctors.DoctorUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class BookAppointmentViewModel @Inject constructor(
    val doctorUseCases: DoctorUseCases,
) : ViewModel() {

    val bookAppointmentState by lazy {
        mutableStateOf(BookAppointmentState())
    }

    fun onEvent(event : BookAppointmentEvents){
        when(event){
            is BookAppointmentEvents.ShowErrorDialog -> {
                bookAppointmentState.value = bookAppointmentState.value.copy(showErrorDialog = true , error = event.error)
            }

            is BookAppointmentEvents.HideErrorDialog -> {
                bookAppointmentState.value = bookAppointmentState.value.copy(showErrorDialog = false , error = null)
            }

            is BookAppointmentEvents.GetDoctorDetails -> {
                viewModelScope.launch {
                    getDoctorDetails(
                        doctorUid = event.doctorUid,
                        onSuccess = {
                            bookAppointmentState.value = bookAppointmentState.value.copy(doctor = it)
                        },
                        onFailure = {
                            onEvent(BookAppointmentEvents.ShowErrorDialog(it))
                        }
                    )
                }
            }
        }
    }

    private suspend fun getDoctorDetails(
        doctorUid : String,
        onSuccess : (Doctor) -> Unit,
        onFailure : (Throwable) -> Unit
    ){
        doctorUseCases.getDoctorDetails(doctorUid, onSuccess, onFailure)
    }
}
