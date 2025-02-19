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
import com.example.desainmu.presentation.ui.designMeasurement.components.AddOrderMeasurementTopBar

@Composable
internal fun AddOrderMeasurementRoute(
    navigateUp: () -> Unit = {},
    design: Design,
    ){
    val viewModel: DesignMeasurementViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AddOrderMeasurementScreen(onEvent = viewModel::handleEvent, uiState, design = design, navigateUp)
}

@Composable
internal fun AddOrderMeasurementScreen(
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState,
    design: Design,
    navigateUp: () -> Unit = {}) {
    Scaffold(
        topBar = { AddOrderMeasurementTopBar(design, navigateUp) },
        content = { padding -> AddOrderMeasurementContent(padding, design = design, onEvent = onEvent, uiState = uiState) }
    )
}

@Preview
@Composable
private fun AddOrderMeasurementScreenPreview() {
    DesainmuTheme {
//        AddOrderMeasurementScreen()
    }
}