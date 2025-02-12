package com.example.desainmu.presentation.designMeasurement.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.ui.component.CustomOutlinedTextFieldNumber

@Composable
internal fun MeasurementAtasanPView() {
    Row {
        AtasanPBadan(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.size(16.dp))
        AtasanPLengan(modifier = Modifier.weight(1f))
    }
}

@Composable
fun AtasanPBadan (modifier: Modifier) {
    Column(modifier = modifier) {
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Leher",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Badan",
            value = "",
            onValueChange = {}
        ) { }
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
            placeHolder = "Panjang Dada",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lebar Dada",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Jarak Bustier",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Tinggi Bustier",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Seluruh Bahu",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Bahu",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Punggung",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lebar Punggung",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Kerung Lengan",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Sisi Badan",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Baju",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Gamis",
            value = "",
            onValueChange = {}
        ) { }
    }
}

@Composable
fun AtasanPLengan (modifier: Modifier) {
    Column (modifier = modifier) {
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Lengan",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Bawah",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Siku",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lebar Siku",
            value = "",
            onValueChange = {}
        ) { }
    }
}