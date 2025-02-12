package com.example.desainmu.presentation.ui.designMeasurement.components

import androidx.compose.runtime.Composable
import com.example.desainmu.model.Design

@Composable
internal fun DesignMeasurementItemView (selectedDesign: Design) {
    when (selectedDesign) {
        Design.Kaos -> {
            MeasurementKaosView()
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
