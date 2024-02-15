package com.example.pearl.presentation.home

import com.example.pearl.R

data class SideMenuItem(
    val name : String,
    val selectedIcon : Int? = null,
    val unSelectedIcon : Int
)

val sideMenuItems = listOf(
    SideMenuItem(
        name = "home",
        selectedIcon = R.drawable.filled_side_menu_home,
        unSelectedIcon = R.drawable.unfilled_side_menu_home
    ),

    SideMenuItem(
        name = "community",
        selectedIcon = R.drawable.filled_side_menu_community,
        unSelectedIcon = R.drawable.unfilled_side_menu_community
    ),
    SideMenuItem(
        name = "My Skin",
        unSelectedIcon = R.drawable.my_skin_side_menu,
    ),
    SideMenuItem(
        name = "My Appointments",
        unSelectedIcon = R.drawable.my_appointments_side_menu,
    ),

    SideMenuItem(
        name = "Favorites",
        unSelectedIcon = R.drawable.unfilled_heart_post,
    ),

    SideMenuItem(
        name = "Privacy & Policy",
        unSelectedIcon = R.drawable.privacy_policy_side_menu,
    ),

    SideMenuItem(
        name = "Settings",
        unSelectedIcon = R.drawable.settings_side_menu,
    ),

    SideMenuItem(
        name = "Qr Code",
        unSelectedIcon = R.drawable.qr_code_side_menu,
    ),
)

