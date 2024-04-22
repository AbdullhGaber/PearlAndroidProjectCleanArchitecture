package com.example.pearl.domain.repositories

import android.content.Context
import arrow.core.Either
import com.example.pearl.domain.model.User
import retrofit2.Call

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

    fun sendOTP(to : String , from : String , body : String)
}