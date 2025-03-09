package com.example.desainmu.presentation.feature.dashboard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.desainmu.presentation.design.components.CustomIconButton
import com.example.desainmu.presentation.design.theme.DesainmuTheme
import com.example.desainmu.presentation.feature.dashboard.components.DashboardContent
import com.example.desainmu.presentation.feature.dashboard.components.DashboardDrawerContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun DashboardRoute(navigateToAddOrder: () -> Unit, navigateToDelayedPayment: () -> Unit, navigateToHistory: () -> Unit) {
    val viewModel: DashboardViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                DashboardEffect.ToHistory -> navigateToHistory.invoke()
                DashboardEffect.ToAddOrder -> navigateToAddOrder.invoke()
                DashboardEffect.ToDelayedPayment -> navigateToDelayedPayment.invoke()
            }
        }
    }
    DashboardScreen(
        onEvent = viewModel::handleEvent,
        uiState = uiState
    )
}

@Composable
private fun DashboardScreen(
    onEvent: (DashboardEvent) -> Unit,
    uiState: DashboardState
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DashboardDrawerContent(onEvent, scope, drawerState)
        },
    ) {
        Scaffold(
            topBar = { MainMenuTopBar(title = "Halaman Utama", drawerState, scope) },
            floatingActionButton = { DashboardFAB(onClick = {onEvent.invoke(DashboardEvent.ToAddOrder)}) },
            content = { padding -> DashboardContent(padding, onEvent, uiState) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainMenuTopBar(
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

@Composable
private fun DashboardFAB(onClick: () -> Unit) {
    FloatingActionButton(onClick = { onClick.invoke() }) {
        Icon(Icons.Filled.Add, "Add")
    }
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    DesainmuTheme {

    }
}