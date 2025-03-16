package com.example.desainmu.presentation.feature.history

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
import com.example.desainmu.presentation.design.components.CustomIconButton
import com.example.desainmu.presentation.feature.dashboard.components.DashboardItemModel
import com.example.desainmu.presentation.feature.history.components.HistoryContent

@Composable
internal fun HistoryRoute(
    navigateUp: () -> Unit = {},
//    dummyValueHistory: List<DashboardItemModel>
) {
    val viewModel: HistoryViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                HistoryEffect.NavigateUp -> navigateUp.invoke()
            }
        }
    }

    HistoryScreen(onEvent = viewModel::handleEvent, uiState,
//        dummyValueHistory
    )
}

@Composable
private fun HistoryScreen(
    onEvent: (HistoryEvent) -> Unit,
    uiState: HistoryState,
//    dummyValueHistory: List<DashboardItemModel>
) {
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    val filteredList by remember(uiState.searchQuery, uiState.items) {
        derivedStateOf {
            if (uiState.searchQuery.isBlank()) {
                uiState.items
            } else {
                uiState.items.filter {
                    it.title.contains(uiState.searchQuery, ignoreCase = true)
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier,
        topBar = {
            HistoryTopBar(
                uiState = uiState,
                onEvent = onEvent
            )
        },
        content = { innerPadding ->
            HistoryContent(
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
private fun HistoryTopBar(
    uiState: HistoryState,
    onEvent: (HistoryEvent) -> Unit
) {
    TopAppBar(
        title = { Text("Riwayat") },
        navigationIcon = {
            BackButton(uiState, onEvent)
        },
        actions = {
            SearchButton(uiState, onEvent)
        }
    )
}

@Composable
private fun BackButton(uiState: HistoryState, onEvent: (HistoryEvent) -> Unit) {
    CustomIconButton(
        icon = Icons.AutoMirrored.Filled.ArrowBack,
        onClick = {
            if (uiState.isSearchActive) {
                onEvent(HistoryEvent.UpdateSearchActive(false))
                onEvent(HistoryEvent.SearchItem(""))
            } else {
                onEvent(HistoryEvent.NavigateUp)
            }
        }
    )
}

@Composable
private fun SearchButton(uiState: HistoryState, onEvent: (HistoryEvent) -> Unit) {
    TextButton(onClick = {
        val newSearchActiveState = !uiState.isSearchActive
        onEvent(HistoryEvent.UpdateSearchActive(newSearchActiveState))
        if (newSearchActiveState) {
            onEvent(HistoryEvent.SearchItem(""))
        }
    }) {
        Text(
            text = if (uiState.isSearchActive) "Tutup" else "Cari",
            color = Color.Blue
        )
    }
}