package com.example.desainmu.presentation.feature.addOrder

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.design.components.CustomIconButton
import com.example.desainmu.presentation.design.theme.DesainmuTheme
import com.example.desainmu.presentation.feature.addOrder.components.AddOrderContent

@Composable
internal fun AddOrderRoute(
    navigateToDesignMeasurement: (Design) -> Unit,
    navigateUp: () -> Unit = {},
//    saveItem: () -> Unit = {},
//    itemsRepository: ItemsRepository
) {
    val viewModel: AddOrderViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                AddOrderEffect.NavigateUp -> navigateUp.invoke()
                is AddOrderEffect.ToMeasurement -> navigateToDesignMeasurement(uiState.selectedDesign)
            }
        }
    }
    AddOrderScreen(uiState = uiState, onEvent = viewModel::handleEvent)
}

@Composable
private fun AddOrderScreen(
    uiState: AddOrderState,
    onEvent: (AddOrderEvent) -> Unit
) {
    Scaffold(
        topBar = { AddOrderTopBar(onEvent) },
        content = { padding -> AddOrderContent(padding, uiState, onEvent) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddOrderTopBar(onEvent: (AddOrderEvent) -> Unit) {
    TopAppBar(
        title = { Text("Tambah Pesanan") },
        navigationIcon = {
            CustomIconButton(
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                onClick = { onEvent.invoke(AddOrderEvent.NavigateUp) }
            )
        }
    )
}

@Preview
@Composable
private fun AddOrderScreenPreview() {
    DesainmuTheme {

    }
}