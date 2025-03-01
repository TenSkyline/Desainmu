package com.example.desainmu.presentation.ui.designMeasurement


import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.theme.DesainmuTheme
import com.example.desainmu.presentation.ui.designMeasurement.components.AddOrderMeasurementContent
import com.example.desainmu.presentation.ui.designMeasurement.components.DesignMeasurementTopBar

@Composable
internal fun DesignMeasurementRoute(
    navigateToResult: (Design) -> Unit,
    navigateUp: () -> Unit = {},
    selectedDesign: Design,
    ){
    val viewModel: DesignMeasurementViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    DesignMeasurementScreen(navigateToResult = navigateToResult, onEvent = viewModel::handleEvent, uiState, selectedDesign = selectedDesign, navigateUp)
}

@Composable
internal fun DesignMeasurementScreen(
    navigateToResult: (Design) -> Unit,
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState,
    selectedDesign: Design,
    navigateUp: () -> Unit = {}) {
    Scaffold(
        topBar = { DesignMeasurementTopBar(selectedDesign, navigateUp) },
        content = { padding -> AddOrderMeasurementContent(padding, navigateToResult = navigateToResult, selectedDesign = selectedDesign, onEvent = onEvent, uiState = uiState) }
    )
}

@Preview
@Composable
private fun AddOrderMeasurementScreenPreview() {
    DesainmuTheme {
//        AddOrderMeasurementScreen()
    }
}