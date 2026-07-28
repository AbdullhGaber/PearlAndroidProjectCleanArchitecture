package com.example.pearl.domain.usecases.authentication

import com.example.pearl.domain.repositories.AuthRepository

class SignUp(
    val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        userDataMap: Map<String, Any>,
        email: String,
        password: String,
        onFailure: (Throwable) -> Unit
    ) {
        authRepository.signUp(userDataMap, email, password, onFailure)
    }
}
