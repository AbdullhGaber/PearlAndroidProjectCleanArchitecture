package com.example.pearl.domain.usecases.authentication

data class AuthUseCases(
    val login : Login,
    val signUp: SignUp,
    val signOut: SignOut,
    val sendOTPMessage: SendOTPMessage,
    val validateEmailUseCase: ValidateEmailUseCase,
    val validatePasswordUseCase: ValidatePasswordUseCase,
    val validateAgeUseCase: ValidateAgeUseCase,
    val validateAddressUseCase: ValidateAddressUseCase,
    val validateNameUseCase: ValidateNameUseCase,
    val resetPasswordUseCase: ResetPasswordUseCase
)
