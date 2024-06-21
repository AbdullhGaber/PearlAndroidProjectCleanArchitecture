package com.example.pearl.presentation.settings

sealed class SettingsEvent {
    data class ShowErrorDialog(val error: Throwable?) : SettingsEvent()
    object HideErrorDialog : SettingsEvent()
    object ShowLoginDialog : SettingsEvent()
    object HideLoginDialog : SettingsEvent()
    object ShowSuccessDialog : SettingsEvent()
    object HideSuccessDialog : SettingsEvent()
}