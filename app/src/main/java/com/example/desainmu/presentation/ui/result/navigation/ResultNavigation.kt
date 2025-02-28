package com.example.desainmu.presentation.ui.result.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.desainmu.presentation.ui.result.ResultRoute

const val RESULT_ROUTE = "result_route"

fun NavController.navigateToResult( navOptions: NavOptions? = null) {
    navigate(RESULT_ROUTE, navOptions)
//    design: Int,
//    navOptions: NavOptions? = null) {
//    val route = "$RESULT_ROUTE/$design"
//    navigate(route , navOptions)
}

fun NavGraphBuilder.resultScreen(navigateUp: () -> Unit = {}) {
//    val route = "$RESULT_ROUTE/{$DesignArgs}"
//    val arguments = listOf(navArgument(DesignArgs) { type = NavType.IntType })
//    composable(route, arguments) { backStackEntry ->
//        val designArgs = backStackEntry.arguments?.getInt(DesignArgs) ?: 0
//        val design = Design.entries.find{ it.ordinal == designArgs } ?: Design.KaosLakiPolaDasar
//        ResultRoute(selectedDesign = design, navigateUp = navigateUp)
//    }
    composable(RESULT_ROUTE) {
        ResultRoute(navigateUp)
    }
}