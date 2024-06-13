package com.example.pearl.presentation.authentication

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pearl.domain.usecases.authentication.AuthUseCases
import com.simon.xmaterialccp.data.utils.checkPhoneNumber
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class AuthViewModel @Inject constructor(
   val authUseCase : AuthUseCases
) : ViewModel() {

    val mAuthState = mutableStateOf(AuthState())

    private suspend fun signUp(
        userDataMap : Map<String , Any>,
        email: String,
        password: String,
        onFailure : (Throwable) -> Unit
    ) {
        authUseCase.signUp(userDataMap , email, password , onFailure)
    }

    private suspend fun login(
        email: String,
        password: String,
        onFailure : (Throwable) -> Unit,
    ){
        authUseCase.login(email , password,onFailure)
    }

    private suspend fun signOut(){
        authUseCase.signOut()
    }

    private suspend fun resetPassword(
        email: String,
        onSuccess : () -> Unit,
        onFailure: (Throwable) -> Unit
    ){
        authUseCase.resetPasswordUseCase(email , onSuccess , onFailure)
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

    private fun validateEmail(){
        val email = mAuthState.value.email

        val result = authUseCase.validateEmailUseCase(email)

        mAuthState.value = mAuthState.value.copy(emailErrorMessage = result.errorMessage)
    }

    private fun validatePassword(){
        val password = mAuthState.value.password

        val result = authUseCase.validatePasswordUseCase(password)

        mAuthState.value = mAuthState.value.copy(passwordErrorMessage = result.errorMessage)
    }

    private fun validateAge(){
        val age = mAuthState.value.age

        val result = authUseCase.validateAgeUseCase(age)

        mAuthState.value = mAuthState.value.copy(ageErrorMessage = result.errorMessage)
    }
    private fun validateAddresses(){
        val state = mAuthState.value.state
        val street = mAuthState.value.street
        val country = mAuthState.value.country

        val result = authUseCase.validateAddressUseCase(
            state = state,
            country = country,
            street = street
        )

        mAuthState.value = mAuthState.value.copy(addressesErrorMessage = result.errorMessage)
    }

    private fun validatePhone() {
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

    fun onEvent(event: AuthEvent){
        when(event){

            is AuthEvent.StartTimer -> {
                viewModelScope.launch {
                   while(mAuthState.value.timeInSeconds > 0 ){
                       delay(1000)
                       val seconds =  mAuthState.value.timeInSeconds
                       Log.e("Timer" , "seconds : $seconds")
                       mAuthState.value = mAuthState.value.copy(timeInSeconds = seconds - 1)
                   }
                }
            }

            is AuthEvent.ResetTimer -> {
                mAuthState.value = mAuthState.value.copy(timeInSeconds = 120)
            }

            is AuthEvent.ResetPassword -> {
               viewModelScope.launch {
                   onEvent(AuthEvent.UpdateIsLoading(true))
                   delay(2000)
                   resetPassword(
                       event.email,
                       event.onSuccess,
                       onFailure = {
                           onEvent(AuthEvent.UpdateError(it))
                       }
                   )
                   onEvent(AuthEvent.UpdateIsLoading(false))
               }
            }

            is AuthEvent.ValidateName -> {
                    validateName()
            }

            is AuthEvent.ValidateInputs -> {
                onEvent(AuthEvent.ValidateName)
                onEvent(AuthEvent.ValidateEmail)
                onEvent(AuthEvent.ValidatePassword)
                onEvent(AuthEvent.ValidateAge)
                onEvent(AuthEvent.ValidateAddresses)
            }

            is AuthEvent.ValidateEmail -> {
                validateEmail()
            }

            is AuthEvent.ValidatePassword -> {
                validatePassword()
            }

            is AuthEvent.ValidateAge -> {
                validateAge()
            }

            is AuthEvent.ValidateAddresses -> {
                validateAddresses()
            }

            is AuthEvent.UpdateShowSuccessDialog -> {
                mAuthState.value = mAuthState.value.copy(showSuccessDialog = event.showDialog)
            }

            is AuthEvent.UpdateEmailField -> {
                mAuthState.value = mAuthState.value.copy(email = event.text)
            }

            is AuthEvent.UpdateState -> {
                mAuthState.value = mAuthState.value.copy(state = event.text)
            }

            is AuthEvent.UpdateStreet -> {
                mAuthState.value = mAuthState.value.copy(street = event.text)
            }

            is AuthEvent.UpdateCountry -> {
                mAuthState.value = mAuthState.value.copy(country = event.text)
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

            is AuthEvent.UpdateAge -> {
                mAuthState.value = mAuthState.value.copy(age = event.text)
            }

            is AuthEvent.UpdateGender -> {
                mAuthState.value = mAuthState.value.copy(gender = event.text)
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

            is AuthEvent.ValidatePhone -> {
                validatePhone()
            }

            is AuthEvent.SendOTPMessage -> {
                val fullPhoneNumber = "${mAuthState.value.phoneCode}${mAuthState.value.phoneNo}"
                val otpCode = generateOTP()
                mAuthState.value = mAuthState.value.copy(generatedOTPCode = otpCode)
                val otpMessage = "Your OTP code is $otpCode"
                Log.e("OTP" , "otp code : $otpCode")
//                sendOTPMessage(fullPhoneNumber,"+12513136756",otpMessage)
            }

            is AuthEvent.VerifyOTPCode -> {

                viewModelScope.launch {
                    onEvent(AuthEvent.UpdateIsLoading(true))
                    delay(2000)
                }

                if(mAuthState.value.otpCode == mAuthState.value.generatedOTPCode){
                    //navigate to quiz screen
                    event.onSuccess()
                    Log.e("OTP TAG" , "otp correct")
                }else{
                    event.onFailure()
                    Log.e("OTP TAG" , "otp not correct")
                }
                onEvent(AuthEvent.UpdateIsLoading(false))
            }

            is AuthEvent.SaveOTPCode -> {
                mAuthState.value = mAuthState.value.copy(otpCode = event.otp)
            }

            is AuthEvent.Login -> {
                viewModelScope.launch {
                    onEvent(AuthEvent.UpdateIsLoading(true))
                    login(
                        event.email ,
                        event.password ,
                        onFailure = {
                            AuthEvent.UpdateError(it)
                        }
                    )
                    delay(2000)
                    AuthEvent.UpdateIsLoading(false)
                }
            }

            is AuthEvent.SignUp -> {
                viewModelScope.launch {
                    onEvent(AuthEvent.UpdateIsLoading(true))
                    delay(2000)
                    val authScreenState = mAuthState.value
                    val phoneNo = authScreenState.phoneNo
                    val phoneCode = authScreenState.phoneCode
                    val fullPhone = "$phoneCode$phoneNo"

                    val userDataMap = mapOf(
                        "firstName" to authScreenState.firstName,
                        "lastName" to authScreenState.lastName,
                        "phoneNumber" to fullPhone,
                        "age" to authScreenState.age,
                        "gender" to authScreenState.gender,
                        "street" to authScreenState.street,
                        "country" to authScreenState.country,
                        "state" to authScreenState.state
                    )

                    signUp(
                        userDataMap,
                        authScreenState.email,
                        authScreenState.password ,
                        onFailure = {
                            e -> onEvent(AuthEvent.UpdateError(e))
                        }
                    )
                    onEvent(AuthEvent.UpdateIsLoading(false))
                }
            }

            is AuthEvent.UpdateError -> {
                Log.e("FIREBASE ERROR" , "error : ${event.error} is updated")
                mAuthState.value = mAuthState.value.copy(
                    isLoading = false,
                    error = if(event.error != null)  event.error.message.toString() else null
                )
            }

            is AuthEvent.UpdateIsLoading -> {
                mAuthState.value = mAuthState.value.copy(isLoading = event.isLoading)
            }

            is AuthEvent.SignOut -> {
                viewModelScope.launch {
                    signOut()
                }
            }
        }
    }

    private fun validateName() {
        val firstName = mAuthState.value.firstName
        val lastName = mAuthState.value.lastName

        val result = authUseCase.validateNameUseCase(firstName,lastName)

        mAuthState.value = mAuthState.value.copy(nameErrorMessage = result.errorMessage)
    }


}