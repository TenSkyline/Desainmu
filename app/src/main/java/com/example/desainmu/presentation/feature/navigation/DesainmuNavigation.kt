package com.example.desainmu.presentation.feature.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.desainmu.presentation.feature.addOrder.navigation.addOrderScreen
import com.example.desainmu.presentation.feature.addOrder.navigation.navigateToAddOrder
import com.example.desainmu.presentation.feature.dashboard.navigation.DASHBOARD_ROUTE
import com.example.desainmu.presentation.feature.dashboard.navigation.dashboardScreen
import com.example.desainmu.presentation.feature.dashboard.navigation.navigateToDashboard
import com.example.desainmu.presentation.feature.delayedPayment.navigation.delayedPaymentScreen
import com.example.desainmu.presentation.feature.delayedPayment.navigation.navigateToDelayedPayment
import com.example.desainmu.presentation.feature.designMeasurement.navigation.designMeasurementScreen
import com.example.desainmu.presentation.feature.designMeasurement.navigation.navigateToDesignMeasurement
import com.example.desainmu.presentation.feature.history.navigation.historyScreen
import com.example.desainmu.presentation.feature.history.navigation.navigateToHistory
import com.example.desainmu.presentation.feature.itemDetail.navigation.itemDetailScreen
import com.example.desainmu.presentation.feature.itemDetail.navigation.navigateToItemDetail
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
        }, navigateToItemDetail = { itemId ->
            navController.navigateToItemDetail(itemId)
        }
        )
        addOrderScreen(
            navigateToDesignMeasurement = {
                navController.navigateToDesignMeasurement(it.ordinal)
            },
            navigateUp = { navController.navigateUp() },
        )
        designMeasurementScreen(
            navigateToResult = {
                navController.navigateToResult(it)
            },
            navigateUp = { navController.navigateUp() })

        delayedPaymentScreen(
            navigateUp = { navController.navigateUp() },
            navigateToItemDetail = { itemId ->
                navController.navigateToItemDetail(itemId)
            }
        )
        historyScreen(navigateUp = { navController.navigateUp() })
        resultScreen(
            navigateToDashboard = {
                navController.navigateToDashboard()
            },
            navigateUp = { navController.navigateUp() }
        )
        itemDetailScreen(navigateUp = { navController.navigateUp() })
    }
}

