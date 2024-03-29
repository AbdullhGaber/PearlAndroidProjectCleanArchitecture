package com.example.pearl.presentation.nav_graph

sealed class Route(val route : String){
    object AppStartNavigation : Route("appStartNavigation")
    object IntroductionScreen : Route("introductionScreen")
    object OnBoardingScreen : Route("onBoardingScreen")
    object AuthNavigation : Route("authNav")
    object SignInScreen : Route("signInScreen")
    object SignUpScreen : Route("signUpScreen")
    object ForgotPasswordByEmailScreen : Route("forgotPasswordByEmailScreen")
    object ForgotPasswordByPhoneScreen : Route("forgotPasswordByPhoneScreen")
    object OTPScreen : Route("otpScreen")
    object QuizScreen : Route("quizScreen")
    object QuizEndingNavigation : Route("quizEndingNavigation")
    object FirstQuizEndingScreen : Route("firstQuizEndingScreen")
    object LastQuizEndingScreen : Route("lastQuizEndingScreen")
    object HomeScreen : Route("homeScreen")
}
