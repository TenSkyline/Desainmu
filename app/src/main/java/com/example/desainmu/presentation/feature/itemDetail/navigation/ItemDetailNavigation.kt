package com.example.desainmu.presentation.feature.itemDetail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.desainmu.presentation.feature.itemDetail.ItemDetailRoute

const val ITEM_DETAIL_ROUTE = "item_detail_route"

fun NavController.navigateToItemDetail(itemId: Int) {
    this.navigate("$ITEM_DETAIL_ROUTE/$itemId")
}

fun NavGraphBuilder.itemDetailScreen(navigateUp: () -> Unit) {
    composable("$ITEM_DETAIL_ROUTE/{itemId}") {
        //No need to extract itemId here — ViewModel will handle it!
        ItemDetailRoute(navigateUp = navigateUp)
    }
}