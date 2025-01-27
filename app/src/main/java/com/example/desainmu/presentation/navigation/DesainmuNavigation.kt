package com.example.desainmu.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.desainmu.presentation.addOrder.navigation.ADD_ORDER_ROUTE
import com.example.desainmu.presentation.addOrder.navigation.addOrderScreen
import com.example.desainmu.presentation.addOrderMeasurement.navigation.addOrderMeasurementScreen
import com.example.desainmu.presentation.addOrderMeasurement.navigation.navigateToAddOrderMeasurement

@Composable
fun DesainmuNavigation (startDestination: String = ADD_ORDER_ROUTE) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        addOrderScreen(navigateToMeasurement = {
            navController.navigateToAddOrderMeasurement(it.ordinal)
        })
        addOrderMeasurementScreen()

    }

}