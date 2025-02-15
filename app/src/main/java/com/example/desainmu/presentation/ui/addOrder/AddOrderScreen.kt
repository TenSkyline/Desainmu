package com.example.desainmu.presentation.ui.addOrder

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.theme.DesainmuTheme
import com.example.desainmu.presentation.ui.addOrder.components.AddOrderContent
import com.example.desainmu.presentation.ui.addOrder.components.AddOrderTopBar

@Composable
internal fun AddOrderRoute(navigateToMeasurement: (Design) -> Unit, navigateUp: () -> Unit = {}) {
    val viewModel: AddOrderViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    AddOrderScreen(
        onClickDesign = navigateToMeasurement,
        navigateUp,
        onEvent = viewModel::handleEvent,
        uiState
    )
}

@Composable
internal fun AddOrderScreen(
    onClickDesign: (Design) -> Unit,
    navigateUp: () -> Unit = {},
    onEvent: (AddOrderEvent) -> Unit,
    uiState: AddOrderState
) {
    Scaffold(
        topBar = { AddOrderTopBar(navigateUp) },
        content = { padding -> AddOrderContent(padding, onClickDesign, onEvent, uiState) }
    )
}

@Preview
@Composable
private fun AddOrderScreenPreview() {
    DesainmuTheme {

    }
}