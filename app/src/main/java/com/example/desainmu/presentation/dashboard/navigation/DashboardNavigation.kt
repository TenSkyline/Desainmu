package com.example.desainmu.presentation.dashboard.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val DASHBOARD_ROUTE = "dashboard_route"

fun NavController.navigateToDashboard(navOptions: NavOptions? = null) {
    navigate(DASHBOARD_ROUTE)
}

fun NavGraphBuilder.dashboardScreen(navigateToHome: () -> Unit) {
    composable(DASHBOARD_ROUTE) {

    }
}