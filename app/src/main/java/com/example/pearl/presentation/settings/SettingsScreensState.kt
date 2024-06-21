package com.example.pearl.presentation.settings

data class SettingsScreensState(
    val error : Throwable? = null,
    val showErrorDialog : Boolean = false,
    val showLoginDialog : Boolean = false,
    val showSuccessDialog : Boolean = false
)
