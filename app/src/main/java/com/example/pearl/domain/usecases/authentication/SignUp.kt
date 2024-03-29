package com.example.pearl.domain.usecases.authentication

import arrow.core.Either
import com.example.pearl.domain.model.User
import com.example.pearl.domain.repositories.AuthRepository

class SignUp(
    val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        user: User,
        password: String,
    ) : Either<Throwable , Unit> {
        return authRepository.signUp(user, password)
    }
}