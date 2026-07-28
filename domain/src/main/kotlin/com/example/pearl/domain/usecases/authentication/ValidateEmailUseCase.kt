package com.example.pearl.domain.usecases.authentication

class ValidateEmailUseCase {
    private val emailPattern = Regex(
        "[a-zA-Z0-9+._%\\-]{1,256}@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+"
    )

    operator fun invoke(email: String): ValidationResult {
        return if (email.isBlank()) {
            ValidationResult(false, "Email cannot be empty")
        } else if (!emailPattern.matches(email)) {
            ValidationResult(false, "Invalid email format")
        } else {
            ValidationResult(true)
        }
    }
}
