package com.example.pearl.domain.usecases.authentication

class ValidateEmailUseCase {
    operator fun invoke(email: String) : ValidationResult{
        return if (email.isBlank()) {
            ValidationResult(false, "Email cannot be empty")
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            ValidationResult(false, "Invalid email format")
        } else {
            ValidationResult(true)
        }
    }
}