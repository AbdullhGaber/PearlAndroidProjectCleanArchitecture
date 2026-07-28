package com.example.pearl.domain.usecases.authentication

data class ValidationResult(val isValid: Boolean, val errorMessage: String? = null)
