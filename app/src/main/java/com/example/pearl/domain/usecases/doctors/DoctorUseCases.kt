package com.example.pearl.domain.usecases.doctors

data class DoctorUseCases(
    val getFavoriteDoctors : GetFavoriteDoctorsUseCase,
    val addFavoriteDoctor : AddFavoriteDoctorUseCase,
    val removeDoctorFromFavorite : RemoveDoctorFromFavoriteUseCase
)
