package com.example.desainmu.presentation.mainMenu.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.desainmu.presentation.addOrder.navigation.ADD_ORDER_ROUTE

const val MAIN_MENU_ROUTE = "main_menu_route"

fun NavController.navigateToMainMenu(navOptions: NavOptions? = null) {
    navigate(MAIN_MENU_ROUTE, navOptions)
}

fun NavController.mainMenuScreen(navOptions: NavOptions? = null) {
    navigate(MAIN_MENU_ROUTE, navOptions)
}