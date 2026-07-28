package com.example.pearl.domain.usecases.authentication

import com.example.pearl.domain.repositories.AuthRepository

class UpdatePasswordUseCase(
    val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email : String,
        password : String,
        newPassword: String,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    ){
        authRepository.updatePassword(email, password, newPassword, onSuccess, onFailure)
    }
}
