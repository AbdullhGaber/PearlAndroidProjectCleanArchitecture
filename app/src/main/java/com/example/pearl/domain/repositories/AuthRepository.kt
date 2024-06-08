package com.example.pearl.domain.repositories


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

    fun sendOTP(to : String , from : String , body : String)
}