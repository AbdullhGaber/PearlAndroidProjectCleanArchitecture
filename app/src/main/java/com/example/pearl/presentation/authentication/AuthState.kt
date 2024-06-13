package com.example.pearl.presentation.authentication

import com.example.pearl.domain.model.UserGender

data class AuthState(
    val email : String = "",
    val firstName : String = "",
    val lastName : String = "",
    val password : String = "",
    val passwordVisibility : Boolean = false,
    val phoneNo : String = "",
    val age : String = "",
    val gender : UserGender = UserGender.MALE,
    val street : String = "",
    val country : String = "",
    val state : String  = "",
    val isValidPhone : Boolean = true,
    val phoneCode : String = "+1",
    val defaultLang : String = "us",
    val otpCode :String = "",
    val generatedOTPCode : String = "",
    val shouldStartSMSRetrieval : Boolean = false,
    val isLoading : Boolean = false,
    val error : String? = null,
    val nameErrorMessage : String? = null,
    val emailErrorMessage : String? = null,
    val passwordErrorMessage : String? = null,
    val ageErrorMessage : String? = null,
    val addressesErrorMessage : String? = null,
    val timeInSeconds : Int = 10,
    val showSuccessDialog : Boolean = false
)
