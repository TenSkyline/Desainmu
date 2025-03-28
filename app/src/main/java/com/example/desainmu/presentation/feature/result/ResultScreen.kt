package com.example.desainmu.presentation.feature.result

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
import com.example.desainmu.presentation.feature.result.components.ResultContent

@Composable
internal fun ResultRoute(
    navigateUp: () -> Unit = {},
    navigateToDashboard: () -> Unit = {},
    selectedDesign: Design
) {
    val viewModel: ResultViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.uiEffect.collect { effect ->
            when (effect) {
                ResultEffect.NavigateUp -> navigateUp.invoke()
                ResultEffect.NavigateToDashboard -> navigateToDashboard.invoke()
            }
        }
    }

    ResultScreen(
        onEvent = viewModel::handleEvent,
        uiState,
        selectedDesign = selectedDesign
    )
}

@Composable
internal fun ResultScreen(
    onEvent: (ResultEvent) -> Unit,
    uiState: ResultState,
    selectedDesign: Design
) {
    Scaffold(
        topBar = { ResultTopBar(onEvent) },
        content = { padding ->
            ResultContent(
                padding,
                uiState = uiState,
                selectedDesign = selectedDesign,
                onEvent = onEvent
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ResultTopBar(onEvent: (ResultEvent) -> Unit) {
    TopAppBar(
        title = { Text("Hasil Ukur") },
        navigationIcon = {
            CustomIconButton(
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                onClick = { onEvent.invoke(ResultEvent.NavigateUp) }
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