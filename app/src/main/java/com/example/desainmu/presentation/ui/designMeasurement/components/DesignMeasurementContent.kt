package com.example.desainmu.presentation.ui.designMeasurement.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.ui.designMeasurement.DesignMeasurementEvent
import com.example.desainmu.presentation.ui.designMeasurement.DesignMeasurementState

@Composable
fun AddOrderMeasurementContent(
    padding: PaddingValues,
    navigateToResult: () -> Unit,
    design: Design,
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState
) {
//    val selectedDesign by remember { mutableStateOf(design) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
    ) {
//        AddOrderMeasurementList(selectedDesign = selectedDesign)
        AddOrderMeasurementList(design = design, onEvent = onEvent, uiState = uiState)
        ElevatedButton(
            onClick = { navigateToResult.invoke()},
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text("Hasil Pengukuran")
        }
    }
}