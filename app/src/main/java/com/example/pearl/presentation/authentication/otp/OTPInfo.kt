package com.example.pearl.presentation.authentication.otp

data class OTPInfo(
    val title : String,
    val subTitle : String,
    val info : String
)

val otpInfoMap = mapOf(
    OTPScreenType.PasswordEmail to OTPInfo(
        "Forgot Password",
        "Enter OTP code we just sent you on your registered email.",
        "We sent you a 5 digit code to your email @ba*****@gmail.com. Check your inbox",
    ),

    OTPScreenType.PasswordMobile to OTPInfo(
        "Forgot Password",
        "Enter OTP code we just sent you on your registered mobile number.",
        "We sent you a 5 digit code to mobile number +20102********. Check your inbox",
    ),

    OTPScreenType.Verification to OTPInfo(
        "Verification",
        "Enter OTP code we just sent you on your registered mobile number.",
        "We sent you a 5 digit code to mobile number +20102********. Check your inbox",
    ),
)