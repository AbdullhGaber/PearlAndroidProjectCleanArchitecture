package com.example.pearl.presentation.pearl_navigator

data class PearlNavState(
    val currentBottomNavItemIndex : Int = 0,
    val sideNavItemIndex : Int = 0,
    val prevNavItemIndex : Int = 0,
    val showBottomNav : Boolean = true,
    val showTopBar : Boolean = true
)
