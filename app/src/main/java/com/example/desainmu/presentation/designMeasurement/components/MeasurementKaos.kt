package com.example.desainmu.presentation.designMeasurement.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.desainmu.ui.component.CustomOutlinedTextField

@Composable
internal fun MeasurementKaosView() {
    Column {
        KaosBadan()
        KaosLengan()
    }
}

@Composable
fun KaosBadan() {
    Column {
        CustomOutlinedTextField(
            placeHolder = "Lingkar Leher",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextField(
            placeHolder = "Lingkar Badan",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextField(
            placeHolder = "Panjang Dada",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextField(
            placeHolder = "Lebar Dada",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextField(
            placeHolder = "Panjang Seluruhnya",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextField(
            placeHolder = "Panjang Bahu",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextField(
            placeHolder = "Panjang Punggung",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextField(
            placeHolder = "Lebar Punggung",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextField(
            placeHolder = "Kerung Lengan",
            value = "",
            onValueChange = {}
        ) { }
    }
}

@Composable
fun KaosLengan(){
    Column {
        CustomOutlinedTextField(
            placeHolder = "Panjang Lengan",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextField(
            placeHolder = "Lebar Lengan",
            value = "",
            onValueChange = {}
        ) { }
    }
}
