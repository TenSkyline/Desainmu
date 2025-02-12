package com.example.desainmu.presentation.ui.designMeasurement.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.presentation.common.sharedComponents.CustomOutlinedTextFieldNumber

@Composable
internal fun MeasurementKaosView() {
    Row {
        KaosBadan(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.size(16.dp))
        KaosLengan(modifier = Modifier.weight(1f))
    }
}

@Composable
fun KaosBadan(modifier: Modifier) {
    Column (modifier = modifier){

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
            placeHolder = "Panjang Seluruhnya",
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
    }
}

@Composable
fun KaosLengan(modifier: Modifier){
    Column (modifier = modifier){
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Lengan",
            value = "",
            onValueChange = {}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lebar Lengan",
            value = "",
            onValueChange = {}
        ) { }
    }
}
