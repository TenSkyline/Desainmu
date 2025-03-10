package com.example.desainmu.presentation.feature.addOrder.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.feature.addOrder.AddOrderRoute

const val ADD_ORDER_ROUTE = "add_order_route"

fun NavController.navigateToAddOrder(navOptions: NavOptions? = null) {
    navigate(ADD_ORDER_ROUTE, navOptions)
}

fun NavGraphBuilder.addOrderScreen(
    navigateToDesignMeasurement: (Design) -> Unit,
    navigateUp: () -> Unit = {},
//    saveItem: () -> Unit,
//    itemsRepository: ItemsRepository
) {
    composable(ADD_ORDER_ROUTE) {
        AddOrderRoute(
            navigateToDesignMeasurement = navigateToDesignMeasurement,
            navigateUp,
//            saveItem,
//            itemsRepository
        )
    }
}