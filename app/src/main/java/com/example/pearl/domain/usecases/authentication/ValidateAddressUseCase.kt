package com.example.pearl.domain.usecases.authentication

class ValidateAddressUseCase {
    operator fun invoke(street: String , state : String , country : String) : ValidationResult{

        return if (street.isBlank() || state.isBlank() || country.isBlank()) {
            ValidationResult(false, "Address Fields must not be empty")
        } else {
            ValidationResult(true)
        }
    }


}