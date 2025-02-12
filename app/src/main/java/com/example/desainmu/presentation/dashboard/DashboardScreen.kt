package com.example.desainmu.presentation.dashboard

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.desainmu.presentation.dashboard.components.DashboardContent
import com.example.desainmu.presentation.dashboard.components.DashboardDrawerContent
import com.example.desainmu.presentation.dashboard.components.DashboardFloatingActionButton
import com.example.desainmu.presentation.dashboard.components.DashboardTopBar
import com.example.desainmu.ui.theme.DesainmuTheme
import kotlinx.coroutines.CoroutineScope

@Composable
internal fun DashboardRoute(navigateToAddOrder: () -> Unit) {
    DashboardScreen(navigateToAddOrder)
}

@Composable
private fun DashboardScreen(onClick: () -> Unit = {}) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            DashboardDrawerContent()
        },
        drawerState = drawerState
    ) {
        DashboardScaffold(drawerState, scope, onClick)
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