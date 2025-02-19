package com.example.desainmu.presentation.ui.designMeasurement.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.ui.designMeasurement.DesignMeasurementEvent
import com.example.desainmu.presentation.ui.designMeasurement.DesignMeasurementState

@Composable
fun AddOrderMeasurementList(
    design: Design,
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 72.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
//            DesignMeasurementItemView(selectedDesign = selectedDesign)
            DesignMeasurementItemView(selectedDesign = design, onEvent = onEvent, uiState = uiState)
        }
    }
}