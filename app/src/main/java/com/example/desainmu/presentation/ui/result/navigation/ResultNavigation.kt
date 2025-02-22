package com.example.desainmu.presentation.ui.result.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.desainmu.presentation.ui.result.ResultRoute

const val RESULT_ROUTE = "result_route"

fun NavController.navigateToResult(navOptions: NavOptions? = null) {
    navigate(RESULT_ROUTE, navOptions)
}

fun NavGraphBuilder.resultScreen(navigateUp: () -> Unit = {}) {
    composable(RESULT_ROUTE) {
        ResultRoute(navigateUp)
    }
}