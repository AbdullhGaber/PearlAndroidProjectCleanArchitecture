package com.example.pearl.domain.usecases.authentication

import android.content.Context
import com.example.pearl.domain.repositories.AuthRepository

class SendOTPMessage(
    val authRepository: AuthRepository
) {
    operator fun invoke(to : String , from : String, otpMessage : String){
        authRepository.sendOTP(to, from,otpMessage)
    }
}