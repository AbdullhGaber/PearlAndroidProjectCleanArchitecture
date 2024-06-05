package com.example.pearl.presentation.home

import androidx.navigation.NavController

sealed class HomeScreenEvents {
    data class NavigateToScreen(val navController : NavController , val route : String) : HomeScreenEvents()
}