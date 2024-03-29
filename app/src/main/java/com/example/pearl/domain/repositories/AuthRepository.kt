package com.example.pearl.domain.repositories

import arrow.core.Either
import com.example.pearl.domain.model.User

interface AuthRepository {
    suspend fun login(
        email: String,
        password: String,
    ) : Either<Throwable , Unit>

    suspend fun signUp(
        user: User,
        password: String,
    ) : Either<Throwable , Unit>

    suspend fun signOut()
}