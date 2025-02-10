package com.example.desainmu.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.desainmu.presentation.addOrder.navigation.addOrderScreen
import com.example.desainmu.presentation.addOrder.navigation.navigateToAddOrder
import com.example.desainmu.presentation.addOrderMeasurement.navigation.addOrderMeasurementScreen
import com.example.desainmu.presentation.addOrderMeasurement.navigation.navigateToAddOrderMeasurement
import com.example.desainmu.presentation.dashboard.navigation.DASHBOARD_ROUTE
import com.example.desainmu.presentation.dashboard.navigation.dashboardScreen

@Composable
fun DesainmuNavigation (startDestination: String = DASHBOARD_ROUTE) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        dashboardScreen(navigateToAddOrder = {
            navController.navigateToAddOrder()
        })
        addOrderScreen(navigateToMeasurement = {
            navController.navigateToAddOrderMeasurement(it.ordinal)
        },
            navigateUp = {navController.navigateUp()})
        addOrderMeasurementScreen(navigateUp = {navController.navigateUp()})

    }

}

