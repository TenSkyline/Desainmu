package com.example.desainmu.presentation.ui.addOrder

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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.common.sharedComponents.CustomIconButton
import com.example.desainmu.presentation.theme.DesainmuTheme
import com.example.desainmu.presentation.ui.addOrder.components.AddOrderContent

@Composable
internal fun AddOrderRoute(
    navigateToDesignMeasurement: (Design) -> Unit,
    navigateUp: () -> Unit = {}
) {
    val viewModel: AddOrderViewModel = viewModel()
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