package com.example.pearl.presentation.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pearl.domain.model.User
import com.example.pearl.domain.usecases.authentication.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    val authUseCases: AuthUseCases
) : ViewModel(){
    var profileScreenState by mutableStateOf(ProfileScreenState())

    init {
        onEvent(ProfileEvents.GetUser)
    }
    fun onEvent(event : ProfileEvents){
        when(event){
            is ProfileEvents.GetUser -> {
               viewModelScope.launch {
                   getUser(
                       onSuccess ={
                           profileScreenState = profileScreenState.copy(user = it)
                       },
                       onFailure = {
                           onEvent(ProfileEvents.ShowErrorDialog)
                           onEvent(ProfileEvents.UpdateErrorMessage(it))
                       }
                   )
               }
            }

            is ProfileEvents.UpdateErrorMessage -> {
                profileScreenState = profileScreenState.copy(errorMessage = event.error)
            }

            is ProfileEvents.ShowSuccessDialog ->{
                profileScreenState = profileScreenState.copy(showSuccessDialog = true)
            }

            is ProfileEvents.HideSuccessDialog ->{
                profileScreenState = profileScreenState.copy(showSuccessDialog = false)
            }

            is ProfileEvents.ShowErrorDialog -> {
                profileScreenState = profileScreenState.copy(showErrorDialog = true)
            }

            is ProfileEvents.HideErrorDialog ->{
                profileScreenState = profileScreenState.copy(showErrorDialog = false)
            }

            is ProfileEvents.UpdateNameField -> {
                profileScreenState = profileScreenState.copy(name = event.text)
            }

            is ProfileEvents.UpdateAgeField -> {
                profileScreenState = profileScreenState.copy(age = event.text)
            }

            is ProfileEvents.UpdateGenderField -> {
                profileScreenState = profileScreenState.copy(gender = event.gender)
            }

            is ProfileEvents.UpdateProfile -> {
                 viewModelScope.launch {
                     updateProfile(
                         user = event.user,
                         onSuccess = {
                            onEvent(ProfileEvents.ShowSuccessDialog)
                         },
                         onFailure = {
                            onEvent(ProfileEvents.ShowErrorDialog)
                            onEvent(ProfileEvents.UpdateErrorMessage(it))
                         }
                     )
                 }
            }
        }
    }

    private suspend fun updateProfile(
        user : User,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        authUseCases.updateProfile(user, onSuccess, onFailure)
    }

    private suspend fun getUser(
        onSuccess: (User) -> Unit,
        onFailure: (Throwable) -> Unit
    ){
        authUseCases.getUser(onSuccess,onFailure)
    }
}