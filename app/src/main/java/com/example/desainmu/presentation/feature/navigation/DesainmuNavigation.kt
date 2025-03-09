package com.example.desainmu.presentation.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.desainmu.presentation.feature.addOrder.navigation.addOrderScreen
import com.example.desainmu.presentation.feature.addOrder.navigation.navigateToAddOrder
import com.example.desainmu.presentation.feature.dashboard.navigation.DASHBOARD_ROUTE
import com.example.desainmu.presentation.feature.dashboard.navigation.dashboardScreen
import com.example.desainmu.presentation.feature.delayedPayment.navigation.delayedPaymentScreen
import com.example.desainmu.presentation.feature.delayedPayment.navigation.navigateToDelayedPayment
import com.example.desainmu.presentation.feature.designMeasurement.navigation.designMeasurementScreen
import com.example.desainmu.presentation.feature.designMeasurement.navigation.navigateToDesignMeasurement
import com.example.desainmu.presentation.feature.history.navigation.historyScreen
import com.example.desainmu.presentation.feature.history.navigation.navigateToHistory
import com.example.desainmu.presentation.feature.result.navigation.navigateToResult
import com.example.desainmu.presentation.feature.result.navigation.resultScreen

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
        addOrderScreen(
            navigateToDesignMeasurement = {
                navController.navigateToDesignMeasurement(it.ordinal)
            },
            navigateUp = { navController.navigateUp() },
//            saveItem = {},
//            itemsRepository = {}
        )
        designMeasurementScreen(navigateToResult = {
            navController.navigateToResult(it)
        },
            navigateUp = { navController.navigateUp() })

        delayedPaymentScreen(navigateUp = { navController.navigateUp() })
        historyScreen(navigateUp = { navController.navigateUp() })
        resultScreen(navigateUp = { navController.navigateUp() })
    }
}

