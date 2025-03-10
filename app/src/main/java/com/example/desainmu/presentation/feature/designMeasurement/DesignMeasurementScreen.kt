package com.example.desainmu.presentation.feature.designMeasurement


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
import com.example.desainmu.presentation.feature.designMeasurement.components.DesignMeasurementContent

@Composable
internal fun DesignMeasurementRoute(
    navigateToResult: (Design) -> Unit,
    navigateUp: () -> Unit = {},
    selectedDesign: Design,
) {
    val viewModel: DesignMeasurementViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                DesignMeasurementEffect.NavigateUp -> navigateUp.invoke()
                is DesignMeasurementEffect.ToResult -> navigateToResult.invoke(effect.design)
            }
        }
    }

    DesignMeasurementScreen(
        onEvent = viewModel::handleEvent,
        uiState,
        selectedDesign = selectedDesign
    )
}

@Composable
internal fun DesignMeasurementScreen(
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState,
    selectedDesign: Design,
) {
    Scaffold(
        topBar = {
            DesignMeasurementTopBar(
                selectedDesign,
                onEvent
            )
        },
        content = { padding ->
            DesignMeasurementContent(
                padding,
                selectedDesign = selectedDesign,
                onEvent = onEvent,
                uiState = uiState
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DesignMeasurementTopBar(
    design: Design,
    onEvent: (DesignMeasurementEvent) -> Unit
) {
    TopAppBar(
        title = { Text("Pengukuran ${design.title}") },
        navigationIcon = {
            CustomIconButton(
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                onClick = { onEvent.invoke(DesignMeasurementEvent.NavigateUp) }
            )
        }
    )
}

@Preview
@Composable
private fun AddOrderMeasurementScreenPreview() {
    DesainmuTheme {
//        AddOrderMeasurementScreen()
    }
}