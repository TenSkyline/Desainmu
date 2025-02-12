package com.example.desainmu.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.desainmu.presentation.ui.addOrder.navigation.addOrderScreen
import com.example.desainmu.presentation.ui.addOrder.navigation.navigateToAddOrder
import com.example.desainmu.presentation.ui.dashboard.navigation.DASHBOARD_ROUTE
import com.example.desainmu.presentation.ui.dashboard.navigation.dashboardScreen
import com.example.desainmu.presentation.ui.delayedPayment.navigation.delayedPaymentScreen
import com.example.desainmu.presentation.ui.delayedPayment.navigation.navigateToDelayedPayment
import com.example.desainmu.presentation.ui.designMeasurement.navigation.addOrderMeasurementScreen
import com.example.desainmu.presentation.ui.designMeasurement.navigation.navigateToAddOrderMeasurement

@Composable
fun DesainmuNavigation(startDestination: String = DASHBOARD_ROUTE) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        dashboardScreen(navigateToAddOrder = {
            navController.navigateToAddOrder()
        }, navigateToDelayedPayment = {
          navController.navigateToDelayedPayment()
        })
        addOrderScreen(navigateToMeasurement = {
            navController.navigateToAddOrderMeasurement(it.ordinal)
        },
            navigateUp = { navController.navigateUp() })
        addOrderMeasurementScreen(navigateUp = { navController.navigateUp() })
        // Make sure you have this line!
        delayedPaymentScreen(navigateUp = { navController.navigateUp() })
    }
}

