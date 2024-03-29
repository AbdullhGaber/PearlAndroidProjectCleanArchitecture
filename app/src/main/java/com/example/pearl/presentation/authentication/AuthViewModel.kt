package com.example.pearl.presentation.authentication

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.example.pearl.domain.model.User
import com.example.pearl.domain.usecases.authentication.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
   val authUseCase : AuthUseCases
) : ViewModel() {

    val mAuthState = mutableStateOf(AuthState())

    private val _authFlowState = MutableStateFlow(AuthFlowState())
    val mAuthFlowState = _authFlowState.asStateFlow()

    private suspend fun signUp(
        user: User,
        password: String,
    ) : Either<Throwable , Unit> {
        return authUseCase.signUp(user, password)
    }

    private suspend fun login(
        email: String,
        password: String,
    ) : Either<Throwable , Unit> {
        return authUseCase.login(email , password)
    }

    private suspend fun signOut(){
        authUseCase.signOut()
    }

    fun onEvent(event: AuthEvent){
        when(event){
            is AuthEvent.UpdateEmailField -> {
                mAuthState.value = mAuthState.value.copy(email = event.text)
            }

            is AuthEvent.UpdatePasswordField -> {
                mAuthState.value = mAuthState.value.copy(password = event.text)
            }

            is AuthEvent.UpdatePasswordVisibility -> {
                mAuthState.value = mAuthState.value.copy(passwordVisibility = !mAuthState.value.passwordVisibility )
            }

            is  AuthEvent.UpdateFirstNameField -> {
                mAuthState.value = mAuthState.value.copy(firstName = event.text)
            }

            is  AuthEvent.UpdateLastNameField -> {
                mAuthState.value = mAuthState.value.copy(lastName = event.text)
            }

            is AuthEvent.UpdatePhoneNumber -> {
                mAuthState.value = mAuthState.value.copy(phoneNo = event.text)
            }

            is AuthEvent.UpdatePhoneCodeDefaultLang -> {
                mAuthState.value = mAuthState.value.copy(phoneCode = event.countryData.countryPhoneCode)
                mAuthState.value = mAuthState.value.copy(defaultLang = event.countryData.countryCode)
            }

            is AuthEvent.UpdatePhoneValidity -> {
                mAuthState.value = mAuthState.value.copy(isValidPhone =  !mAuthState.value.isValidPhone)
            }

            is AuthEvent.ResendOTPCode -> {

            }

            is AuthEvent.Login -> {
                viewModelScope.launch {
                    _authFlowState.update{it.copy(isLoading = true)}
                    login(
                        event.email ,
                        event.password ,
                    ).onLeft {
                        viewModelScope.launch {
                            _authFlowState.update {state -> state.copy(isLoading = false , error = it.message.toString()) }
                        }
                    }
                    delay(2000)
                    _authFlowState.update{it.copy(isLoading = false)}
                }
            }

            is AuthEvent.SignUp -> {
                viewModelScope.launch {
                    _authFlowState.update{it.copy(isLoading = true)}

                    val user = User(
                        email = event.email,
                        firstName = event.firstName,
                        lastName = event.lastName,
                    )

                    signUp(
                        user ,
                        event.password ,
                    ).onLeft {
                        viewModelScope.launch {
                            _authFlowState.update {state -> state.copy(isLoading = false , error = it.message.toString()) }
                        }
                    }

                    delay(2000)
                    _authFlowState.update{it.copy(isLoading = false)}
                }
            }

            is AuthEvent.SignOut -> {
                viewModelScope.launch {
                    signOut()
                }
            }
        }
    }
}