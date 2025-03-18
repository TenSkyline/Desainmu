package com.example.desainmu.presentation.feature.dashboard.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.desainmu.presentation.feature.dashboard.DashboardRoute

const val DASHBOARD_ROUTE = "dashboard_route"

fun NavController.navigateToDashboard(navOptions: NavOptions? = null) {
    navigate(DASHBOARD_ROUTE)
}

fun NavGraphBuilder.dashboardScreen(
    navigateToAddOrder: () -> Unit,
    navigateToDelayedPayment: () -> Unit,
    navigateToHistory: () -> Unit,
    navigateToItemDetail: (Int) -> Unit
) {
    composable(DASHBOARD_ROUTE) {
        DashboardRoute(
            navigateToAddOrder = navigateToAddOrder,
            navigateToDelayedPayment = navigateToDelayedPayment,
            navigateToHistory = navigateToHistory,
            navigateToItemDetail = navigateToItemDetail
        )
    }
}