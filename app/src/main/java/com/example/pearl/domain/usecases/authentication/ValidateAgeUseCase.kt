package com.example.pearl.domain.usecases.authentication

class ValidateAgeUseCase {
    operator fun invoke(age: String) : ValidationResult{

        return if (age.isBlank()) {
            ValidationResult(false, "Age cannot be empty")
        } else {
            ValidationResult(true)
        }
    }


}