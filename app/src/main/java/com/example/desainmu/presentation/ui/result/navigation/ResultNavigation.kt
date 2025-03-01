package com.example.desainmu.presentation.ui.result.navigation

import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.desainmu.model.Design
import com.example.desainmu.model.NavArgs.DesignArgs
import com.example.desainmu.presentation.ui.result.ResultRoute

const val RESULT_ROUTE = "result_route"

fun NavController.navigateToResult(design: Design, navOptions: NavOptions? = null) {
    val route = "$RESULT_ROUTE/${design.ordinal}"
    navigate(route, navOptions)
}

fun NavGraphBuilder.resultScreen(navigateUp: () -> Unit = {}) {
    val route = "$RESULT_ROUTE/{${DesignArgs}}"
    val arguments = listOf(navArgument(DesignArgs) { type = NavType.IntType })
    composable(route, arguments) { backStackEntry ->
        val designOrdinal = backStackEntry.arguments?.getInt(DesignArgs) ?: 0
        val design = Design.entries.find { it.ordinal == designOrdinal } ?: Design.KaosLakiPolaDasar
        ResultRoute(selectedDesign = design, navigateUp = navigateUp)
    }
}

//fun NavController.navigateToResult( navOptions: NavOptions? = null) {
//    navigate(RESULT_ROUTE, navOptions)
//
//}
//
//fun NavGraphBuilder.resultScreen(navigateUp: () -> Unit = {}) {
//
//    composable(RESULT_ROUTE) {
//        ResultRoute(navigateUp)
//    }
//}