package com.example.pearl.presentation.profile

import com.example.pearl.domain.model.User
import com.example.pearl.domain.model.UserGender

sealed class ProfileEvents {
    data class UpdateNameField(val text : String) : ProfileEvents()
    data class UpdateGenderField(val gender : UserGender) : ProfileEvents()
    data class UpdateAgeField(val text : String) : ProfileEvents()
    data class UpdateProfile(val user : User) : ProfileEvents()

    object ShowSuccessDialog : ProfileEvents()
    object HideSuccessDialog : ProfileEvents()
    object ShowErrorDialog : ProfileEvents()
    object HideErrorDialog : ProfileEvents()
    data class UpdateErrorMessage(val error : Throwable?) : ProfileEvents()
    object GetUser : ProfileEvents()
}