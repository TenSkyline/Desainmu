package com.example.desainmu.presentation.feature.designMeasurement.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.desainmu.model.Design
import com.example.desainmu.model.NavArgs.DesignArgs
import com.example.desainmu.presentation.feature.designMeasurement.DesignMeasurementRoute

const val DESIGN_MEASUREMENT_ROUTE = "design_measurement_route"

fun NavController.navigateToDesignMeasurement(
    design: Int,navOptions: NavOptions? = null) {
    val route = "$DESIGN_MEASUREMENT_ROUTE/$design"
    navigate(route , navOptions)
}

fun NavGraphBuilder.designMeasurementScreen(navigateToResult: (Design) -> Unit, navigateUp: () -> Unit = {}) {
    val route = "$DESIGN_MEASUREMENT_ROUTE/{$DesignArgs}"
    val arguments = listOf(navArgument(DesignArgs) { type = NavType.IntType })
    composable(route, arguments) { backStackEntry ->
        val designArgs = backStackEntry.arguments?.getInt(DesignArgs) ?: 0
        val design = Design.entries.find{ it.ordinal == designArgs } ?: Design.KaosLakiPolaDasar
        DesignMeasurementRoute(navigateToResult = {selectedDesign -> navigateToResult(selectedDesign)}, selectedDesign = design, navigateUp = navigateUp)
    }
}