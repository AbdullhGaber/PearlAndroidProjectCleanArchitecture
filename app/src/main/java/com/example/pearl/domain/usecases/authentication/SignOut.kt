package com.example.pearl.domain.usecases.authentication

import com.example.pearl.domain.repositories.AuthRepository

class SignOut(
    val authRepository: AuthRepository
) {
    suspend operator fun invoke(){
        authRepository.signOut()
    }
}