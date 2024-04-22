package com.example.pearl.presentation.nav_graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.pearl.presentation.authentication.AuthViewModel
import com.example.pearl.presentation.authentication.otp.OTPScreen
import com.example.pearl.presentation.authentication.otp.OTPScreenType
import com.example.pearl.presentation.authentication.otp.otpInfoMap
import com.example.pearl.presentation.authentication.sign_in.SignInScreen
import com.example.pearl.presentation.authentication.sign_up.SignUpScreen
import com.example.pearl.presentation.home.HomeScreen
import com.example.pearl.presentation.introduction.IntroductionScreen
import com.example.pearl.presentation.onboarding.OnBoardingScreen
import com.example.pearl.presentation.skin_quiz.QuestionViewModel
import com.example.pearl.presentation.skin_quiz.QuizScreen

@Composable
fun NavGraph(
    startDestination : String
){
    val navController  = rememberNavController()
    val authViewModel : AuthViewModel = hiltViewModel()
    val state by authViewModel.mAuthFlowState.collectAsStateWithLifecycle()

    NavHost(navController = navController , startDestination = startDestination){
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.IntroductionScreen.route
        ){

            composable(route = Route.IntroductionScreen.route){
                IntroductionScreen(
                    navigateToOnBoardingScreen = {
                        navigateToTab(
                            navController,
                            Route.OnBoardingScreen.route
                        )
                    }
                )

            }

            composable(route = Route.OnBoardingScreen.route){
                OnBoardingScreen(
                    navigateToAuthScreen = {
                        navigateToTab(navController = navController , Route.AuthNavigation.route)
                    }
                )
            }
        }

        navigation(startDestination = Route.SignUpScreen.route, route = Route.AuthNavigation.route){
            composable(
                route = Route.SignUpScreen.route
            ){
                SignUpScreen(
                    authState = authViewModel.mAuthState.value,
                    authFlowState = state,
                    authEvent = authViewModel::onEvent,
                    navigateToSignIn = {
                        navigateToTab(navController = navController , Route.SignInScreen.route)
                    },
                    navigateToOTPScreen = {
                        navigateToTab(navController = navController , Route.OTPScreen.route)
                    }
                )
            }

            composable(
                route = Route.SignInScreen.route
            ){
                SignInScreen(
                    authState = authViewModel.mAuthState.value,
                    authFlowState = state,
                    authEvent = authViewModel::onEvent,
                    navigateToSignUp = {
                        navigateToTab(navController = navController , Route.SignUpScreen.route)
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
                        navigateToTab(navController = navController , Route.QuizScreen.route)
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
                    navigateToTab(navController , Route.HomeScreen.route)
                }
            )
        }

        composable(route = Route.HomeScreen.route){
            HomeScreen()
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

@Preview
@Composable
fun PreviewNavGraph(){
    NavGraph(startDestination = Route.AppStartNavigation.route)
}