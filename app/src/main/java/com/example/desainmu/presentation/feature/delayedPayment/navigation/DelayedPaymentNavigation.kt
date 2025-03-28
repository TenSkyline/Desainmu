package com.example.desainmu.presentation.feature.delayedPayment.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
//import com.example.desainmu.presentation.feature.dashboard.components.dummyValueDelayed
import com.example.desainmu.presentation.feature.delayedPayment.DelayedPaymentRoute

const val DELAYED_PAYMENT_ROUTE = "delayed_payment_route"

fun NavController.navigateToDelayedPayment(navOptions: NavOptions? = null) {
    navigate(DELAYED_PAYMENT_ROUTE, navOptions)
}

fun NavGraphBuilder.delayedPaymentScreen(
    navigateUp: () -> Unit = {},
    navigateToItemDetail: (Int) -> Unit
) {
    composable(DELAYED_PAYMENT_ROUTE) {
        DelayedPaymentRoute(
            navigateUp,
            navigateToItemDetail = navigateToItemDetail
        )
    }
}