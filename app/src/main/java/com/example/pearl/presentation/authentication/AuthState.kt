package com.example.pearl.presentation.authentication

import androidx.compose.ui.text.input.TextFieldValue

data class AuthState(
    val email : String = "",
    val firstName : String = "",
    val lastName : String = "",
    val password : String = "",
    val passwordVisibility : Boolean = false,
    val phoneNo : String = "",
    val isValidPhone : Boolean = false,
    val phoneCode : String = "",
    val defaultLang : String = "",
    val otpTextList : List<TextFieldValue> = emptyList()
)
