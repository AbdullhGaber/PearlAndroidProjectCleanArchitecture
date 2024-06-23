package com.example.pearl.presentation.profile

import com.example.pearl.domain.model.User
import com.example.pearl.domain.model.UserGender


data class ProfileScreenState(
    val user : User = User(),
    val name : String = user.name,
    val gender: UserGender = user.gender,
    val age : String = user.age,
    val showSuccessDialog : Boolean = false,
    val showErrorDialog: Boolean = false,
    val errorMessage : Throwable? = null
)
