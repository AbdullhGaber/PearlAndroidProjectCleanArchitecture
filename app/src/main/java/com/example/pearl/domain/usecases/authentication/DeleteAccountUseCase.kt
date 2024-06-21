package com.example.pearl.domain.usecases.authentication

import com.example.pearl.domain.repositories.AuthRepository

class DeleteAccountUseCase(
    val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email : String,
        password : String,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    ){
        authRepository.deleteAccount(email, password, onSuccess, onFailure)
    }
}
