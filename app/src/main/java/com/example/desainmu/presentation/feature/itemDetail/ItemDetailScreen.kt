package com.example.desainmu.presentation.feature.itemDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.desainmu.presentation.design.components.CustomIconButton

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
fun ItemDetailScreen(
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

@Composable
private fun ItemDetailContent(
    innerPadding: PaddingValues,
    uiState: ItemDetailState,
    onEvent: (ItemDetailEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            ItemDetailView(uiState = uiState)
            ElevatedButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Text("Edit")
            }
            ElevatedButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Text("Hapus")
            }
        }
    }
}

@Composable
private fun ItemDetailView(uiState: ItemDetailState){
    when {
            uiState.isLoading -> Text("Loading...")
            uiState.error != null -> Text(uiState.error)
            uiState.item != null -> {
                Text("Title: ${uiState.item.title}")
                Text("Description: ${uiState.item.description}")
                Text("Date Added: ${uiState.item.dateAdded}")
                Text("Selected Date: ${uiState.item.selectedDate}")
            }
        }
}