package com.example.desainmu.presentation.ui.result

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.theme.DesainmuTheme
import com.example.desainmu.presentation.ui.result.components.ResultDesignImage
import com.example.desainmu.presentation.ui.result.components.ResultDetails
import com.example.desainmu.presentation.ui.result.components.ResultTopBar

@Composable
internal fun ResultRoute(
    navigateUp: () -> Unit = {},
    selectedDesign: Design
) {
    val viewModel: ResultViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
//    onEvent = viewModel::handleEvent, uiState, navigateUp
    ResultScreen(uiState, navigateUp = navigateUp, selectedDesign = selectedDesign)
}

@Composable
internal fun ResultScreen(
    uiState: ResultState,
    navigateUp: () -> Unit = {},
    selectedDesign: Design
) {
    // Collect the lingkarBadan value from the ViewModel
    Scaffold(
        topBar = { ResultTopBar(navigateUp) },
//        ResultContent(padding, design = design, onEvent = onEvent, uiState = uiState)
        content = { padding ->
            ResultContent(padding, uiState = uiState, selectedDesign = selectedDesign)
        }
    )
}

@Composable
fun ResultContent(padding: PaddingValues, uiState: ResultState, selectedDesign: Design) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
    ) {
        item {
            ResultDesignImage(selectedDesign = selectedDesign)
        }
        item {
            ResultDetails(uiState = uiState, selectedDesign = selectedDesign)
        }
        item {
            ElevatedButton(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Simpan")
            }
        }
    }
}


@Preview
@Composable
private fun AddOrderMeasurementScreenPreview() {
    DesainmuTheme {
//        AddOrderMeasurementScreen()
    }
}