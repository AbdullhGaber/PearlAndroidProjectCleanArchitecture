package com.example.pearl.domain.usecases.authentication

data class AuthUseCases(
    val login : Login,
    val signUp: SignUp,
    val signOut: SignOut
)
