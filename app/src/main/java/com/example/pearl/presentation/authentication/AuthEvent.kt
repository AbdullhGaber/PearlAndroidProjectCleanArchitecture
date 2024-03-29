package com.example.pearl.presentation.authentication

import com.simon.xmaterialccp.data.CountryData

sealed class AuthEvent{
    data class UpdateFirstNameField(val text : String) : AuthEvent()
    data class UpdateLastNameField(val text : String) : AuthEvent()
    data class UpdateEmailField(val text : String) : AuthEvent()
    data class UpdatePasswordField(val text : String) : AuthEvent()
    object UpdatePasswordVisibility : AuthEvent()
    data class UpdatePhoneNumber(val text : String) : AuthEvent()
    object UpdatePhoneValidity : AuthEvent()
    data class UpdatePhoneCodeDefaultLang(val countryData: CountryData) : AuthEvent()
    object ResendOTPCode : AuthEvent()
    data class Login(val email : String , val password : String) : AuthEvent()
    data class SignUp(
        val email : String, val firstName : String, val lastName : String, val password : String
    ) : AuthEvent()
    object SignOut : AuthEvent()
}
