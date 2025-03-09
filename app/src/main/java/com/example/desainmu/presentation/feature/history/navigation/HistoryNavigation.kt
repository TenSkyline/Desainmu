package com.example.desainmu.presentation.feature.history.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.desainmu.presentation.feature.dashboard.components.dummyValueHistory
import com.example.desainmu.presentation.feature.history.HistoryRoute

const val HISTORY_ROUTE = "history_route"

fun NavController.navigateToHistory(navOptions: NavOptions? = null) {
    navigate(HISTORY_ROUTE, navOptions)
}

fun NavGraphBuilder.historyScreen(navigateUp: () -> Unit = {}) {
    composable(HISTORY_ROUTE) {
        HistoryRoute(navigateUp, dummyValueHistory)
    }
}