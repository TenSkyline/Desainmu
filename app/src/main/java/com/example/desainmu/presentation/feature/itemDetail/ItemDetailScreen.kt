package com.example.desainmu.presentation.feature.itemDetail

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.desainmu.presentation.design.components.CustomIconButton
import com.example.desainmu.presentation.feature.itemDetail.components.ItemDetailContent

@Composable
internal fun ItemDetailRoute(
    navigateUp: () -> Unit
) {
    val viewModel: ItemDetailViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    // Handle UI Effects
    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            if (uiState.error != null) {
                // Handle error
                println(uiState.error)
            }
            when (effect) {
                ItemDetailEffect.NavigateUp -> navigateUp.invoke()
            }
        }
    }
    ItemDetailScreen(
        onEvent = viewModel::handleEvent,
        uiState
    )
}

@Composable
private fun ItemDetailScreen(
    onEvent: (ItemDetailEvent) -> Unit,
    uiState: ItemDetailState
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            ItemDetailTopBar(
                onEvent = onEvent
            )
        },
        content = { innerPadding ->
            ItemDetailContent(
                innerPadding = innerPadding,
                uiState = uiState,
                onEvent = onEvent
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ItemDetailTopBar(
    onEvent: (ItemDetailEvent) -> Unit
) {
    TopAppBar(
        title = { Text("Detail Pesanan") },
        navigationIcon = {
            CustomIconButton(
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                onClick = { onEvent.invoke(ItemDetailEvent.NavigateUp) }
            )
        }
    )
}

