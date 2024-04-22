package com.example.pearl.presentation.authentication

data class AuthState(
    val email : String = "",
    val firstName : String = "",
    val lastName : String = "",
    val password : String = "",
    val passwordVisibility : Boolean = false,
    val phoneNo : String = "",
    val isValidPhone : Boolean = true,
    val phoneCode : String = "+1",
    val defaultLang : String = "us",
    val otpCode :String = "",
    val generatedOTPCode : String = "",
    val shouldStartSMSRetrieval : Boolean = false
)
