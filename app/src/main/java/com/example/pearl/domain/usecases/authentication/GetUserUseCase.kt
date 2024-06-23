package com.example.pearl.domain.usecases.authentication

import arrow.fx.coroutines.ExitCase
import com.example.pearl.domain.model.User
import com.example.pearl.domain.repositories.AuthRepository

class GetUserUseCase(
    val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        onSuccess : (User) -> Unit,
        onFailure: (Throwable) -> Unit
    ){
        authRepository.getUser(onSuccess, onFailure)
    }
}