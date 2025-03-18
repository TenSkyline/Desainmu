package com.example.desainmu.presentation.feature.itemDetail

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.desainmu.presentation.design.components.CustomIconButton
import com.example.desainmu.presentation.design.components.CustomOutlinedTextFieldView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 80.dp) // To make space for buttons
            ) {
                ItemDetailView(uiState = uiState)
            }

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp) // Adds space between buttons
            ) {
                ElevatedButton(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Edit")
                }
                ElevatedButton(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Hapus")
                }
            }
        }
    }
}

@Composable
private fun ItemDetailView(uiState: ItemDetailState) {
    when {
        uiState.isLoading -> Text("Loading...")
        uiState.error != null -> Text(uiState.error)
        uiState.item != null -> {
            CustomOutlinedTextFieldView(
                placeHolder = "Judul",
                value = uiState.item.title
            )
            CustomOutlinedTextFieldView(
                placeHolder = "Deskripsi",
                value = uiState.item.description
            )
            Text("Tanggal Pesan: ${formatDate(uiState.item.dateAdded)}")
            Text("Tenggat Waktu: ${formatDate(uiState.item.selectedDate)}")
        }
    }
}

private fun formatDate(longDate: Long?): String {
    if (longDate == null) return "-"
    val sdf = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
    return sdf.format(Date(longDate))
}