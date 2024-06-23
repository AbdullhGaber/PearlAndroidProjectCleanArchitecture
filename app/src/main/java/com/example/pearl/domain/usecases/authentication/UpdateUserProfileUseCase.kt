package com.example.pearl.domain.usecases.authentication

import com.example.pearl.domain.model.User
import com.example.pearl.domain.repositories.AuthRepository

class UpdateUserProfileUseCase(
    val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        user : User,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    ){
        authRepository.updateProfile(user, onSuccess, onFailure)
    }
}