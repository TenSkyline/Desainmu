package com.example.desainmu.presentation.ui.dashboard

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.desainmu.presentation.theme.DesainmuTheme
import com.example.desainmu.presentation.ui.dashboard.components.DashboardContent
import com.example.desainmu.presentation.ui.dashboard.components.DashboardDrawerContent
import com.example.desainmu.presentation.ui.dashboard.components.DashboardFloatingActionButton
import com.example.desainmu.presentation.ui.dashboard.components.DashboardTopBar
import kotlinx.coroutines.CoroutineScope

@Composable
internal fun DashboardRoute(navigateToAddOrder: () -> Unit, navigateToDelayedPayment: () -> Unit) {
    DashboardScreen(navigateToAddOrder, navigateToDelayedPayment)
}

@Composable
private fun DashboardScreen(navigateToAddOrder: () -> Unit, navigateToDelayedPayment: () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DashboardDrawerContent(navigateToDelayedPayment, scope, drawerState)
        },
    ) {
        DashboardScaffold(drawerState, scope, navigateToAddOrder)
    }
}

@Composable
private fun DashboardScaffold(
    drawerState: DrawerState,
    scope: CoroutineScope,
    onClick: () -> Unit
) {
    Scaffold(
        topBar = { DashboardTopBar(drawerState, scope) },
        floatingActionButton = { DashboardFloatingActionButton(onClick) },
        content = { padding -> DashboardContent(padding) }
    )
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    DesainmuTheme {

    }
}