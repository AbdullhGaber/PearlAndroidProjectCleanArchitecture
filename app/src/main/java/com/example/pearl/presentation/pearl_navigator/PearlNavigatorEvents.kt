package com.example.pearl.presentation.pearl_navigator

import androidx.navigation.NavController

sealed class PearlNavigatorEvents {
    data class NavigateTo(val route : String , val navController: NavController) : PearlNavigatorEvents()
    data class NavigateToPrevious(val navController: NavController) : PearlNavigatorEvents()
    data class NavigateToPreviousBottomTab(val navController: NavController) : PearlNavigatorEvents()
    data class NavigateToPreviousSideTab(val navController: NavController) : PearlNavigatorEvents()
    data class UpdateBottomNavItemIndex(val index : Int) : PearlNavigatorEvents()
    data class UpdateSideNavItemIndex(val index : Int) : PearlNavigatorEvents()
    data class CheckForBottomNavVisibility(val navController: NavController) : PearlNavigatorEvents()
    data class CheckForTopBarVisibility(val navController: NavController) : PearlNavigatorEvents()
}