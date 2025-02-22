package com.example.desainmu.presentation.ui.designMeasurement.components

import androidx.compose.runtime.Composable
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.ui.designMeasurement.DesignMeasurementEvent
import com.example.desainmu.presentation.ui.designMeasurement.DesignMeasurementState

@Composable
internal fun DesignMeasurementItemView (
    selectedDesign: Design,
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState
) {
    when (selectedDesign) {
        Design.KaosLakiPolaDasar -> {
            MeasurementKaosLakiPolaDasarView(onEvent = onEvent, uiState = uiState)
        }
        Design.Celana -> {
            MeasurementCelanaView(onEvent = onEvent, uiState = uiState)
        }
        Design.KemejaL -> {
            MeasurementKemejaLView(onEvent = onEvent, uiState = uiState)
        }
        Design.KemejaP -> {
            MeasurementKemejaPView(onEvent = onEvent, uiState = uiState)
        }
        Design.Rok -> {
            MeasurementRokView(onEvent = onEvent, uiState = uiState)
        }
        Design.AtasanPerempuan -> {
            MeasurementAtasanPView(onEvent = onEvent, uiState = uiState)
        }
    }
}
