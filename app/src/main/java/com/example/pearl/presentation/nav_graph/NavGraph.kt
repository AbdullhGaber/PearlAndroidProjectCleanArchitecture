package com.example.pearl.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.pearl.presentation.authentication.AuthViewModel
import com.example.pearl.presentation.authentication.change_password.ChangePasswordScreen
import com.example.pearl.presentation.authentication.forgot_password.ConfirmPassword
import com.example.pearl.presentation.authentication.forgot_password.ForgotPasswordByEmailScreen
import com.example.pearl.presentation.authentication.forgot_password.ForgotPasswordByPhoneNumberScreen
import com.example.pearl.presentation.authentication.otp.OTPScreen
import com.example.pearl.presentation.authentication.otp.OTPScreenType
import com.example.pearl.presentation.authentication.otp.otpInfoMap
import com.example.pearl.presentation.authentication.sign_in.SignInScreen
import com.example.pearl.presentation.authentication.sign_up.SignUpScreen
import com.example.pearl.presentation.introduction.IntroductionScreen
import com.example.pearl.presentation.onboarding.OnBoardingScreen
import com.example.pearl.presentation.onboarding.OnBoardingViewModel
import com.example.pearl.presentation.pearl_navigator.NavigatorViewModel
import com.example.pearl.presentation.pearl_navigator.PearlNavigator
import com.example.pearl.presentation.privacy_policy.PrivacyPolicy
import com.example.pearl.presentation.skin_quiz.QuestionViewModel
import com.example.pearl.presentation.skin_quiz.QuizScreen

@Composable
fun NavGraph(
    startDestination : String,
){
    val navHostController  = rememberNavController()
    val authViewModel : AuthViewModel = hiltViewModel()
    val onBoardingViewModel : OnBoardingViewModel = hiltViewModel()

    NavHost(navController = navHostController , startDestination = startDestination){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.IntroductionScreen.route
        ){
            composable(route = Route.IntroductionScreen.route){
                IntroductionScreen(
                    navigateToOnBoardingScreen = {
                        navigateToTab(
                            navHostController,
                            Route.OnBoardingScreen.route
                        )
                    }
                )

            }
            composable(route = Route.OnBoardingScreen.route){
                OnBoardingScreen(
                    navigateToAuthScreen = {
                        navigateToTab(navController = navHostController , Route.AuthNavigation.route)
                    },
                    onBoardingEvent = onBoardingViewModel::onEvent
                )
            }
        }

        composable(
            route = Route.OTPScreen.route
        ){
            OTPScreen(
                otpInfo = otpInfoMap[OTPScreenType.Verification]!!,
                authEvent = authViewModel::onEvent ,
                authState = authViewModel.mAuthState.value,
                navigateToQuizScreen = {
                    navigateToTab(navController = navHostController , Route.QuizScreen.route)
                },
                navigateUp = {
                    navigateToPreviousTab(navHostController)
                }
            )
        }

        navigation(route = Route.AuthNavigation.route, startDestination = Route.SignUpScreen.route){
            composable(
                route = Route.SignUpScreen.route
            ){
                SignUpScreen(
                    authState = authViewModel.mAuthState.value,
                    authEvent = authViewModel::onEvent,
                    navigateToScreen = {
                        navigateToTab(navController = navHostController , it)
                    }
                )
            }

            composable(
                route = Route.SignInScreen.route
            ){
                SignInScreen(
                    authState = authViewModel.mAuthState.value,
                    authEvent = authViewModel::onEvent,
                    navigateToScreen = {
                        navigateToTab(navController = navHostController , it)
                    }
                )
            }

            composable(
                route = Route.OTPScreen.route
            ){
                OTPScreen(
                    otpInfo = otpInfoMap[OTPScreenType.Verification]!!,
                    authEvent = authViewModel::onEvent ,
                    authState = authViewModel.mAuthState.value,
                    navigateToQuizScreen = {
                        navigateToTab(navController = navHostController , Route.QuizScreen.route)
                    },
                    navigateUp = {
                        navigateToPreviousTab(navHostController)
                    }
                )
            }

            composable(route = Route.ForgotPasswordByPhoneScreen.route){
                ForgotPasswordByPhoneNumberScreen(
                    authEvent = authViewModel::onEvent ,
                    authState = authViewModel.mAuthState.value,
                    navigateToScreen = {
                        navigateToTab(navHostController , it)
                    },
                    navigateUp = {
                        navigateToPreviousTab(navHostController)
                    }
                )
            }

            composable(route = Route.ForgotPasswordByEmailScreen.route){
                ForgotPasswordByEmailScreen(
                    authEvent = authViewModel::onEvent ,
                    authState = authViewModel.mAuthState.value,
                    navigateToScreen = {
                        navigateToTab(navHostController , it)
                    },
                    navigateUp = {
                        navigateToPreviousTab(navHostController)
                    }
                )
            }

            composable(route = Route.ChangePasswordScreen.route){
                ChangePasswordScreen(
                    authEvent = authViewModel::onEvent,
                    authState = authViewModel.mAuthState.value,
                    navigateToScreen = {
                        navigateToTab(navHostController , it)
                    },
                    navigateUp = {
                        navigateToPreviousTab(navHostController)
                    }
                )
            }

            composable(route = Route.ConfirmPasswordScreen.route) {
                ConfirmPassword(
                    authEvent = authViewModel::onEvent,
                    authState = authViewModel.mAuthState.value,
                    navigateToScreen = {
                        navigateToTab(navHostController, it)
                    },
                    navigateUp = {
                        navigateToPreviousTab(navHostController)
                    }
                )
            }

            composable(route = Route.PrivacyPolicyScreen.route){
                PrivacyPolicy(
                    navigateToPreviousTab = {
                        navigateToPreviousTab(navHostController)
                    }
                )
            }
        }

        composable(route = Route.QuizScreen.route){
            val questionViewModel : QuestionViewModel = hiltViewModel()
            QuizScreen(
                quizScreenState = questionViewModel.quizScreenState.value,
                questionEvent = questionViewModel::onEvent,
                navigateToHome = {
                    navigateToTab(navHostController , Route.PearlNavigation.route)
                }
            )
        }

        composable(route = Route.PearlNavigation.route){
            val viewModel : NavigatorViewModel = hiltViewModel()
            PearlNavigator(
                pearlNavState = viewModel.mPearlNavState.value ,
                pearlNavEvent = viewModel::onEvent ,
                navHostController = navHostController
            )
        }
    }
}

fun navigateToTab(navController: NavController, route : String){
    navController.navigate(route){
        navController.graph.startDestinationRoute?.let {
            restoreState = true
            launchSingleTop = true
        }
    }
}

fun navigateToPreviousTab(navController: NavController){
    navController.navigateUp()
}

@Preview
@Composable
fun PreviewNavGraph(){
    NavGraph(startDestination = Route.AppStartNavigation.route)
}