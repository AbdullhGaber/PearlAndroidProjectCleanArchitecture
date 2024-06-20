package com.example.pearl.presentation.dermatologists

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pearl.domain.model.Doctor
import com.example.pearl.domain.usecases.doctors.DoctorUseCases
import com.example.pearl.domain.usecases.products.ProductUseCases
import com.example.pearl.presentation.favorites.FavoriteScreenEvents
import com.example.pearl.presentation.favorites.FavoritesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DermatologistViewModel @Inject constructor(
    private val mProductUseCase: ProductUseCases,
    private val mDoctorUseCase: DoctorUseCases
) : ViewModel() {

    private val mFavoriteViewModel = FavoritesViewModel(mDoctorUseCase,mProductUseCase)
    val doctorScreenState = mutableStateOf(DoctorScreenState())
    fun onEvent(event : DoctorEvents){
        when(event){
            is DoctorEvents.AddRemoveFavoriteDoctor -> {
                addRemoveDoctor(event.doctor)
            }

            is DoctorEvents.ObserveOnDoctorList -> {
                observeDoctorList(event.doctors)
            }
        }
    }
    private fun addRemoveDoctor(doctor : Doctor){
        mFavoriteViewModel.onEvent(FavoriteScreenEvents.DoctorAction(doctor))
    }


    private fun observeDoctorList(doctorList : List<Doctor>){
        doctorScreenState.value = doctorScreenState.value.copy(doctors = doctorList)
    }

}