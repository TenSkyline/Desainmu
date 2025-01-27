package com.example.desainmu.presentation.addOrderMeasurement.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.desainmu.model.Design
import com.example.desainmu.model.NavArgs.DesignArgs
import com.example.desainmu.presentation.addOrderMeasurement.AddOrderMeasurementRoute

const val ADD_ORDER_MEASUREMENT_ROUTE = "add_order_measurement_route"

fun NavController.navigateToAddOrderMeasurement(
    design: Int,navOptions: NavOptions? = null) {
    val route = "$ADD_ORDER_MEASUREMENT_ROUTE/$design"
    navigate(route , navOptions)
}

fun NavGraphBuilder.addOrderMeasurementScreen() {
    val route = "$ADD_ORDER_MEASUREMENT_ROUTE/{$DesignArgs}"
    val arguments = listOf(navArgument(DesignArgs) { type = NavType.IntType })
    composable(route, arguments) { backStackEntry ->
        val designArgs = backStackEntry.arguments?.getInt(DesignArgs) ?: 0
        val design = Design.entries.find{ it.ordinal == designArgs } ?: Design.entries
        AddOrderMeasurementRoute(design = design)
    }
}