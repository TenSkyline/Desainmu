package com.example.desainmu.presentation.ui.dashboard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import com.example.desainmu.presentation.common.sharedComponents.CustomIconButton
import com.example.desainmu.presentation.common.sharedComponents.GenericScaffold
import com.example.desainmu.presentation.theme.DesainmuTheme
import com.example.desainmu.presentation.ui.dashboard.components.DashboardContent
import com.example.desainmu.presentation.ui.dashboard.components.DashboardDrawerContent
import com.example.desainmu.presentation.ui.dashboard.components.DashboardFloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

sealed class DashboardNav {
    data object ToDelayed : DashboardNav()
    data object ToHistory : DashboardNav()
    data object ToAddOrder : DashboardNav()
}

@Composable
internal fun DashboardRoute(navigateToAddOrder: () -> Unit, navigateToDelayedPayment: () -> Unit, navigateToHistory: () -> Unit) {
    val eventVariation: (DashboardNav) -> Unit = {
        when (it) {
            is DashboardNav.ToAddOrder -> navigateToAddOrder()
            is DashboardNav.ToDelayed -> navigateToDelayedPayment()
            is DashboardNav.ToHistory -> navigateToHistory()
        }
    }
    DashboardScreen(navigationEvent = eventVariation)
}

@Composable
private fun DashboardScreen(
    navigationEvent: (DashboardNav) -> Unit,
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DashboardDrawerContent(navigationEvent, scope, drawerState)
        },
    ) {
//        DashboardScaffold(drawerState, scope, navigateToAddOrder)
        GenericScaffold(title = "",
            drawerState, scope) {
            Scaffold(
                topBar = { MainMenuTopBar(title = "Halaman Utama", drawerState, scope) },
                floatingActionButton = { DashboardFloatingActionButton(onClick = {navigationEvent.invoke(DashboardNav.ToAddOrder)}) },
                content = { padding -> DashboardContent(padding) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenuTopBar(
    title: String,
    drawerState: DrawerState,
    scope: CoroutineScope,
    navigationIcon: @Composable (() -> Unit)? = {
        CustomIconButton(
            icon = Icons.Default.Menu,
            onClick = {
                scope.launch {
                    if (drawerState.isClosed) {
                        drawerState.open()
                    } else {
                        drawerState.close()
                    }
                }
            }
        )
    },
    actions: @Composable () -> Unit = {}
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = { navigationIcon?.invoke() },
        actions = { actions() }
    )
}

//@Composable
//private fun DashboardScaffold(
//    drawerState: DrawerState,
//    scope: CoroutineScope,
//    onClick: () -> Unit
//) {
//    Scaffold(
//        topBar = { DashboardTopBar(drawerState, scope) },
//        floatingActionButton = { DashboardFloatingActionButton(onClick) },
//        content = { padding -> DashboardContent(padding) }
//    )
//}

@Preview
@Composable
private fun DashboardScreenPreview() {
    DesainmuTheme {

    }
}