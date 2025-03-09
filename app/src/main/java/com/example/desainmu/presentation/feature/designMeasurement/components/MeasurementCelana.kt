package com.example.desainmu.presentation.feature.designMeasurement.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.desainmu.presentation.design.components.CustomOutlinedTextFieldNumber
import com.example.desainmu.presentation.feature.designMeasurement.DesignMeasurementEvent
import com.example.desainmu.presentation.feature.designMeasurement.DesignMeasurementState

@Composable
internal fun MeasurementCelanaView(
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState
) {
    Celana(
        modifier = Modifier,
        onEvent = onEvent,
        uiState = uiState)
}

@Composable
fun Celana (
    modifier: Modifier,
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState) {
    Column (modifier = modifier){
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Pinggang",
            value = uiState.lingkarPinggang,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LingkarPinggang(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Panggul 1",
            value = uiState.lingkarPanggul1,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LingkarPanggul1(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Panggul 2",
            value = uiState.lingkarPanggul2,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LingkarPanggul2(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Tinggi Panggul",
            value = uiState.tinggiPanggul,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.TinggiPanggul(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Miatak",
            value = uiState.lingkarMiatak,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LingkarMiatak(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Paha Atas",
            value = uiState.pahaAtas,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PahaAtas(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Celana",
            value = uiState.panjangCelana,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangCelana(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Lutut",
            value = uiState.panjangLutut,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangLutut(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Lutut",
            value = uiState.lingkarLutut,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LingkarLutut(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Bawah Celana",
            value = uiState.lingkarBawahCelana,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LingkarBawahCelana(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Tinggi Duduk",
            value = uiState.tinggiDuduk,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.TinggiDuduk(it))}
        ) { }
    }
}