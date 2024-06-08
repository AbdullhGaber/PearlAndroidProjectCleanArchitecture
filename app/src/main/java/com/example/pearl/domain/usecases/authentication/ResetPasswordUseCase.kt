package com.example.pearl.domain.usecases.authentication

import com.example.pearl.domain.repositories.AuthRepository

class ResetPasswordUseCase(
    val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email : String,
        onSuccess : () -> Unit,
        onFailure: (Throwable) -> Unit
    ){
        authRepository.resetPassword(email , onSuccess , onFailure)
    }
}