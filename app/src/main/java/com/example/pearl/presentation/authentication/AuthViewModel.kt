package com.example.pearl.presentation.authentication

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.example.pearl.domain.model.User
import com.example.pearl.domain.usecases.authentication.AuthUseCases
import com.simon.xmaterialccp.data.utils.checkPhoneNumber
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

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

    private fun generateOTP() : String{

        val otp = StringBuilder()

        repeat(5){
            otp.append(Random.nextInt(10))
        }

        return otp.toString()
    }

    private fun sendOTPMessage(to : String , from : String, otpMessage : String){
        authUseCase.sendOTPMessage(to , from , otpMessage)
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

            is AuthEvent.UpdatePhoneCode -> {
                mAuthState.value = mAuthState.value.copy(phoneCode = event.phoneCode)
            }

            is AuthEvent.UpdatePhoneDefaultLang -> {
                mAuthState.value = mAuthState.value.copy(defaultLang = event.defaultLanguage)
            }

            is AuthEvent.UpdatePhoneCodeAndDefaultLang -> {
                mAuthState.value = mAuthState.value.copy(phoneCode = event.countryData.countryPhoneCode)
                mAuthState.value = mAuthState.value.copy(defaultLang = event.countryData.countryCode)
            }

            is AuthEvent.UpdatePhoneValidity -> {
                val phoneNo = mAuthState.value.phoneNo
                val phoneCode = mAuthState.value.phoneCode
                val defaultLang = mAuthState.value.defaultLang
                val fullPhone = "$phoneCode$phoneNo"

                val isValid = checkPhoneNumber(
                    phone = phoneNo,
                    fullPhoneNumber = fullPhone,
                    countryCode = defaultLang
                )

                mAuthState.value = mAuthState.value.copy(isValidPhone = isValid)
            }

            is AuthEvent.SendOTPMessage -> {
                val fullPhoneNumber = "${mAuthState.value.phoneCode}${mAuthState.value.phoneNo}"
                val otpCode = generateOTP()
                mAuthState.value = mAuthState.value.copy(generatedOTPCode = otpCode)
                val otpMessage = "Your OTP code is $otpCode"
                sendOTPMessage(fullPhoneNumber,"+12513136756",otpMessage)
            }

            is AuthEvent.VerifyOTPCode -> {
                if(mAuthState.value.otpCode == mAuthState.value.generatedOTPCode){
                    //navigate to quiz screen
                    onEvent(
                        AuthEvent.SignUp(
                            mAuthState.value.email ,
                            mAuthState.value.firstName ,
                            mAuthState.value.lastName ,
                            mAuthState.value.password
                        )
                    )
                    event.navigateToQuizScreen()
                    Log.e("OTP TAG" , "otp correct")
                }else{
                    //display error message
                    Log.e("OTP TAG" , "otp not correct")
                }
            }

            is AuthEvent.SaveOTPCode -> {
                mAuthState.value = mAuthState.value.copy(otpCode = event.otp)
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