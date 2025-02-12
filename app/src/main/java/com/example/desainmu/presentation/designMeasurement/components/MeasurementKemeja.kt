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
internal fun MeasurementKemejaLView() {
    Row {
        KemejaLBadan(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.size(16.dp))
        KemejaLengan(modifier = Modifier.weight(1f))
    }
}

@Composable
internal fun MeasurementKemejaPView() {
    Row {
        KemejaPBadan(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.size(16.dp))
        KemejaLengan(modifier = Modifier.weight(1f))
    }
}

@Composable
fun KemejaLBadan (modifier: Modifier) {
    Column (modifier = modifier) {
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
            placeHolder = "Lebar Dada",
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
            placeHolder = "Panjang Baju",
            value = "",
            onValueChange = {}
        ) { }
    }
}

@Composable
fun KemejaPBadan (modifier: Modifier) {
    Column (modifier = modifier) {
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
            placeHolder = "Lebar Dada",
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
            placeHolder = "Panjang Baju",
            value = "",
            onValueChange = {}
        ) { }
    }
}

@Composable
fun KemejaLengan (modifier: Modifier) {
    Column (modifier = modifier) {
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Lengan Panjang",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lebar Lengan Panjang",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Lengan Pendek",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lebar Lengan Pendek",
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
        CustomOutlinedTextFieldNumber(
            placeHolder = "Ban Tangan",
            value = "",
            onValueChange = {}
        ) { }
    }
}