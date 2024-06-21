package com.example.pearl.presentation.settings

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pearl.presentation.routines.RoutineEvents
import dagger.hilt.android.lifecycle.HiltViewModel


class SettingsViewModel : ViewModel() {
    val settingsScreensState  = mutableStateOf(SettingsScreensState())
    fun onEvent(event : SettingsEvent){
        when(event){
            is SettingsEvent.ShowSuccessDialog -> {
                settingsScreensState.value = settingsScreensState.value.copy(showSuccessDialog = true)
            }

            is SettingsEvent.HideSuccessDialog -> {
                settingsScreensState.value = settingsScreensState.value.copy(showSuccessDialog = false)
            }

            is SettingsEvent.HideErrorDialog -> {
                settingsScreensState.value = settingsScreensState.value.copy(showErrorDialog = false)
                settingsScreensState.value = settingsScreensState.value.copy(error = null)
            }

            is SettingsEvent.ShowErrorDialog -> {
                settingsScreensState.value = settingsScreensState.value.copy(showErrorDialog = true)
                settingsScreensState.value = settingsScreensState.value.copy(error = event.error)
            }

            is SettingsEvent.HideLoginDialog -> {
                settingsScreensState.value = settingsScreensState.value.copy(showLoginDialog = false)
            }

            is SettingsEvent.ShowLoginDialog -> {
                settingsScreensState.value = settingsScreensState.value.copy(showLoginDialog = true)
            }
        }
    }
}