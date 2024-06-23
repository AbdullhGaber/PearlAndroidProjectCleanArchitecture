package com.example.pearl.domain.repositories

import com.example.pearl.domain.model.User
import kotlinx.coroutines.flow.Flow


interface AuthRepository {
    suspend fun login(
        email: String,
        password: String,
        onFailure : (Throwable) -> Unit
    )

    suspend fun signUp(
        userDataMap : Map<String , Any>,
        email: String,
        password: String,
        onFailure : (Throwable) -> Unit
    )

    suspend fun signOut()

    suspend fun resetPassword(
        email : String,
        onSuccess : () -> Unit,
        onFailure: (Throwable) -> Unit
    )

    suspend fun deleteAccount(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    )
    suspend fun updatePassword(
        email : String,
        password: String ,
        newPassword : String,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    )

    suspend fun updateProfile(
        user : User,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    )

    suspend fun getUser(
        onSuccess: (User) -> Unit,
        onFailure: (Throwable) -> Unit
    )

    fun sendOTP(to : String , from : String , body : String)
}