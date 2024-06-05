package com.example.pearl.presentation.pearl_navigator

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.pearl.presentation.common.getIndexByBottomNavRoute
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.nav_graph.bottomNavRoutes
import com.example.pearl.presentation.nav_graph.navigateToPreviousTab
import com.example.pearl.presentation.nav_graph.navigateToTab
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigatorViewModel @Inject constructor(): ViewModel() {
    val mPearlNavState = mutableStateOf(PearlNavState())
    fun onEvent(event : PearlNavigatorEvents){
        when(event){
            is PearlNavigatorEvents.NavigateTo -> {
                navigateToTab(navController = event.navController , event.route)

                onEvent(PearlNavigatorEvents.CheckForBottomNavVisibility(event.navController))
                onEvent(PearlNavigatorEvents.CheckForTopBarVisibility(event.navController))
            }

            is PearlNavigatorEvents.NavigateToPrevious -> {
                navigateToPreviousTab(navController = event.navController)
                onEvent(PearlNavigatorEvents.CheckForBottomNavVisibility(event.navController))
                onEvent(PearlNavigatorEvents.CheckForTopBarVisibility(event.navController))
            }

            is PearlNavigatorEvents.UpdateBottomNavItemIndex -> {
                mPearlNavState.value = mPearlNavState.value.copy(prevNavItemIndex = mPearlNavState.value.currentBottomNavItemIndex)
                mPearlNavState.value = mPearlNavState.value.copy(currentBottomNavItemIndex = event.index)
            }

            is PearlNavigatorEvents.UpdateSideNavItemIndex -> {
                mPearlNavState.value = mPearlNavState.value.copy(sideNavItemIndex = event.index)
            }

            is PearlNavigatorEvents.NavigateToPreviousBottomTab -> {
                navigateToPreviousTab(event.navController)

                val prevIndex = mPearlNavState.value.prevNavItemIndex

                val prevRoute = event.navController.previousBackStackEntry?.destination?.route ?: Route.HomeScreen.route

                val newPrevIndex = getIndexByBottomNavRoute(prevRoute)

                mPearlNavState.value = mPearlNavState.value.copy(currentBottomNavItemIndex = prevIndex)
                mPearlNavState.value = mPearlNavState.value.copy(prevNavItemIndex = newPrevIndex)

                onEvent(PearlNavigatorEvents.CheckForBottomNavVisibility(event.navController))
                onEvent(PearlNavigatorEvents.CheckForTopBarVisibility(event.navController))
            }

            is PearlNavigatorEvents.NavigateToPreviousSideTab -> {
                navigateToTab(event.navController,Route.HomeScreen.route)
                mPearlNavState.value = mPearlNavState.value.copy(prevNavItemIndex = 0)
                mPearlNavState.value = mPearlNavState.value.copy(currentBottomNavItemIndex = 0)

                onEvent(PearlNavigatorEvents.CheckForBottomNavVisibility(event.navController))
                onEvent(PearlNavigatorEvents.CheckForTopBarVisibility(event.navController))
            }

            is PearlNavigatorEvents.CheckForBottomNavVisibility -> {
                val currentRoute = event.navController.currentBackStackEntry?.destination?.route

                val shouldShowBottomNav = bottomNavRoutes.contains(currentRoute)

                mPearlNavState.value = mPearlNavState.value.copy(showBottomNav = shouldShowBottomNav)
            }

            is PearlNavigatorEvents.CheckForTopBarVisibility -> {
                val currentRoute = event.navController.currentBackStackEntry?.destination?.route

                val shouldShowTopBar = currentRoute == Route.HomeScreen.route

                mPearlNavState.value = mPearlNavState.value.copy(showTopBar = shouldShowTopBar)
            }
        }
    }
}