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
        Design.Kaos -> {
            MeasurementKaosView(onEvent = onEvent, uiState = uiState)
        }
        Design.Celana -> {
            MeasurementCelanaView()
        }
        Design.KemejaL -> {
            MeasurementKemejaLView()
        }
        Design.KemejaP -> {
            MeasurementKemejaPView()
        }
        Design.Rok -> {
            MeasurementRokView()
        }
        Design.AtasanPerempuan -> {
            MeasurementAtasanPView()
        }
    }
}
