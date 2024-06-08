package com.example.pearl.presentation.authentication

import android.content.Context
import com.example.pearl.domain.model.UserGender
import com.simon.xmaterialccp.data.CountryData

sealed class AuthEvent{
    data class UpdateFirstNameField(val text : String) : AuthEvent()
    data class UpdateLastNameField(val text : String) : AuthEvent()
    data class UpdateEmailField(val text : String) : AuthEvent()
    data class UpdatePasswordField(val text : String) : AuthEvent()
    object UpdatePasswordVisibility : AuthEvent()
    data class UpdatePhoneNumber(val text : String) : AuthEvent()
    data class UpdateAge(val text : String) : AuthEvent()
    data class UpdateGender(val text : UserGender) : AuthEvent()
    data class UpdateState(val text : String) : AuthEvent()
    data class UpdateStreet(val text : String) : AuthEvent()
    data class UpdateCountry(val text : String) : AuthEvent()
    data class UpdatePhoneDefaultLang(val defaultLanguage : String) : AuthEvent()
    data class UpdatePhoneCode(val phoneCode : String) : AuthEvent()
    data class UpdatePhoneCodeAndDefaultLang(val countryData: CountryData) : AuthEvent()
    object ValidatePhone : AuthEvent()
    object ValidateEmail : AuthEvent()
    object ValidatePassword : AuthEvent()
    object ValidateAge : AuthEvent()
    object ValidateAddresses : AuthEvent()
    object ValidateName : AuthEvent()
    object ValidateInputs : AuthEvent()
    data class Login(val email : String , val password : String) : AuthEvent()
    data class ResetPassword(
        val email: String,
        val onSuccess: () -> Unit,
    ) : AuthEvent()

    object StartTimer : AuthEvent()
    object ResetTimer : AuthEvent()
    object SignUp : AuthEvent()
    data class UpdateError(val error :  Throwable? = null) : AuthEvent()
    data class UpdateIsLoading(val isLoading : Boolean) : AuthEvent()
    data class SendOTPMessage(val context: Context) : AuthEvent()
    data class VerifyOTPCode(val onSuccess : () -> Unit , val onFailure : () -> Unit) : AuthEvent()
    data class SaveOTPCode(val otp : String) : AuthEvent()
    object SignOut : AuthEvent()
}
