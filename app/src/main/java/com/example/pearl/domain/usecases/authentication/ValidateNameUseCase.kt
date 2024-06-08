package com.example.pearl.domain.usecases.authentication

class ValidateNameUseCase {

    operator fun invoke(firstName: String , lastName : String) : ValidationResult{

        return if (firstName.isBlank() || lastName.isBlank()) {
            ValidationResult(false, "Name fields cannot be empty")
        }else {
            ValidationResult(true)
        }
    }
}