package com.example.pearl.domain.usecases.authentication

import arrow.core.Either
import com.example.pearl.domain.repositories.AuthRepository

class Login(
    val authRepository: AuthRepository
){
    suspend operator fun invoke(
        email: String,
        password: String,
        onFailure : (Throwable) -> Unit
    ){
        authRepository.login(email , password , onFailure)
    }
}
