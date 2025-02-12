package com.example.desainmu.presentation.ui.designMeasurement.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.desainmu.presentation.common.sharedComponents.CustomOutlinedTextFieldNumber

@Composable
internal fun MeasurementCelanaView() {
    Celana(modifier = Modifier)
}

@Composable
fun Celana (modifier: Modifier) {
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
            placeHolder = "Lingkar Miatak",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Paha Atas",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Celana",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Lutut",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Lutut",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Bawah Celana",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Tinggi Duduk",
            value = "",
            onValueChange = {}
        ) { }
    }
}