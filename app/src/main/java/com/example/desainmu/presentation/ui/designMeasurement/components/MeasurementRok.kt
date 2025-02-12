package com.example.desainmu.presentation.ui.designMeasurement.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.desainmu.presentation.common.sharedComponents.CustomOutlinedTextFieldNumber

@Composable
internal fun MeasurementRokView() {
    Rok(modifier = Modifier)
}

@Composable
fun Rok (modifier: Modifier) {
    Column (modifier = modifier){
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Pinggang",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Panggul 1",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Panggul 2",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Tinggi Panggul",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Rok",
            value = "",
            onValueChange = {}
        ) { }
    }
}