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
import com.example.desainmu.presentation.ui.designMeasurement.navigation.designMeasurementScreen
import com.example.desainmu.presentation.ui.designMeasurement.navigation.navigateToDesignMeasurement
import com.example.desainmu.presentation.ui.history.navigation.historyScreen
import com.example.desainmu.presentation.ui.history.navigation.navigateToHistory
import com.example.desainmu.presentation.ui.result.navigation.navigateToResult
import com.example.desainmu.presentation.ui.result.navigation.resultScreen

@Composable
fun DesainmuNavigation(startDestination: String = DASHBOARD_ROUTE) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        dashboardScreen(navigateToAddOrder = {
            navController.navigateToAddOrder()
        }, navigateToDelayedPayment = {
            navController.navigateToDelayedPayment()
        }, navigateToHistory = {
            navController.navigateToHistory()
        })
        addOrderScreen(navigateToDesignMeasurement = {
            navController.navigateToDesignMeasurement(it.ordinal)
        },
            navigateUp = { navController.navigateUp() })
        designMeasurementScreen(navigateToResult = {
            navController.navigateToResult()
        },
            navigateUp = { navController.navigateUp() })

        delayedPaymentScreen(navigateUp = { navController.navigateUp() })
        historyScreen(navigateUp = { navController.navigateUp() })
        resultScreen(navigateUp = { navController.navigateUp() })
    }
}

