package com.example.pearl.domain.usecases.authentication

class ValidatePasswordUseCase {
    operator fun invoke(password: String): ValidationResult {
        return if (password.isBlank()) {
            ValidationResult(false, "Password cannot be empty")
        } else if (password.length < 8) {
            ValidationResult(false, "Password must be at least 8 characters long")
        } else {
            ValidationResult(true)
        }
    }
}