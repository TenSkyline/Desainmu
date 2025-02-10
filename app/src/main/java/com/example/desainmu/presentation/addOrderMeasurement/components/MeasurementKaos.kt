package com.example.desainmu.presentation.addOrderMeasurement.components

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.desainmu.ui.component.CustomOutlinedTextField

@Composable
internal fun MeasurementKaosView() {
    CustomOutlinedTextField(
        placeHolder = "Lingkar Leher",
        value = "",
    ) { }
    CustomOutlinedTextField(
        placeHolder = "Lingkar Badan",
        value = "",
    ) { }
}