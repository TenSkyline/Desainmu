package com.example.desainmu.presentation.ui.delayedPayment

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.desainmu.presentation.common.sharedComponents.CustomIconButton
import com.example.desainmu.presentation.ui.dashboard.components.OrderItemModel
import com.example.desainmu.presentation.ui.delayedPayment.components.DelayedPaymentContent

@Composable
internal fun DelayedPaymentRoute(
    navigateUp: () -> Unit = {},
    dummyValueDelayed: List<OrderItemModel>,

    ) {
    val viewModel: DelayedPaymentViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                DelayedPaymentEffect.NavigateUp -> navigateUp.invoke()
            }
        }
    }

    DelayedPaymentScreen(onEvent = viewModel::handleEvent, uiState, dummyValueDelayed)
}

@Composable
private fun DelayedPaymentScreen(
    onEvent: (DelayedPaymentEvent) -> Unit,
    uiState: DelayedPaymentState,
    dummyValueDelayed: List<OrderItemModel>
) {
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    val filteredList by remember(uiState.searchQuery, dummyValueDelayed) {
        derivedStateOf {
            if (uiState.searchQuery.isBlank()) {
                dummyValueDelayed
            } else {
                dummyValueDelayed.filter {
                    it.title.contains(uiState.searchQuery, ignoreCase = true)
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier,
        topBar = {
            DelayedPaymentTopBar(
                uiState = uiState,
                onEvent = onEvent
            )
        },
        content = { innerPadding ->
            DelayedPaymentContent(
                innerPadding = innerPadding,
                uiState = uiState,
                filteredList = filteredList,
                onEvent = onEvent,
                focusManager = focusManager,
                context = context
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DelayedPaymentTopBar(
    uiState: DelayedPaymentState,
    onEvent: (DelayedPaymentEvent) -> Unit
) {
    TopAppBar(
        title = { Text("Belum Bayar") },
        navigationIcon = {
            BackButton(uiState, onEvent)
        },
        actions = {
            SearchButton(uiState, onEvent)
        }
    )
}

@Composable
private fun BackButton(uiState: DelayedPaymentState, onEvent: (DelayedPaymentEvent) -> Unit) {
    CustomIconButton(
        icon = Icons.AutoMirrored.Filled.ArrowBack,
        onClick = {
            if (uiState.isSearchActive) {
                onEvent(DelayedPaymentEvent.UpdateSearchActive(false))
                onEvent(DelayedPaymentEvent.SearchItem(""))
            } else {
                onEvent(DelayedPaymentEvent.NavigateUp)
            }
        }
    )
}

@Composable
private fun SearchButton(uiState: DelayedPaymentState, onEvent: (DelayedPaymentEvent) -> Unit) {
    TextButton(onClick = {
        val newSearchActiveState = !uiState.isSearchActive
        onEvent(DelayedPaymentEvent.UpdateSearchActive(newSearchActiveState))
        if (newSearchActiveState) {
            onEvent(DelayedPaymentEvent.SearchItem(""))
        }
    }) {
        Text(
            text = if (uiState.isSearchActive) "Tutup" else "Cari",
            color = Color.Blue
        )
    }
}


