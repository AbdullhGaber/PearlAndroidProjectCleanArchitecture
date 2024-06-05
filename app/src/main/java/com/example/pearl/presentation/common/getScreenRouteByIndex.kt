package com.example.pearl.presentation.common

import com.example.pearl.presentation.nav_graph.Route

fun getBottomNavigationScreenRouteByIndex(index : Int) : String {
    val route = when(index){
        0 -> Route.HomeScreen.route
        1 -> Route.ProgressScreen.route
        2 -> Route.ProductsScreen.route
        3 -> Route.RoutineScreen.route
        else -> Route.CommunityScreen.route
    }
    return route
}

fun getDrawerNavigationScreenRouteByIndex(index : Int) : String {
    val route = when(index){
        0 -> Route.HomeScreen.route
        1 -> Route.CommunityScreen.route
        2 -> Route.MySkinScreen.route
        3 -> Route.MyAppointmentsScreen.route
        4 -> Route.FavoritesScreen.route
        5 -> Route.PrivacyPolicyScreen.route
        6 -> Route.SettingsScreen.route
        else -> Route.QrCodeScreen.route
    }
    return route
}

fun getIndexByBottomNavRoute(route : String) : Int{
    val index = when(route) {
        Route.HomeScreen.route -> 0
        Route.ProgressScreen.route -> 1
        Route.ProductsScreen.route -> 2
        Route.RoutineScreen.route -> 3
        Route.CommunityScreen.route -> 4
        else -> -1
    }

    return index
}

