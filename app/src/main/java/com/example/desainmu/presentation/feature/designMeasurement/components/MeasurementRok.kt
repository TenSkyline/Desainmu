package com.example.desainmu.presentation.feature.designMeasurement.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.desainmu.presentation.design.components.CustomOutlinedTextFieldNumber
import com.example.desainmu.presentation.feature.designMeasurement.DesignMeasurementEvent
import com.example.desainmu.presentation.feature.designMeasurement.DesignMeasurementState

@Composable
internal fun MeasurementRokView(
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState
) {
    Rok(
        modifier = Modifier,
        onEvent = onEvent,
        uiState = uiState
        )
}

@Composable
fun Rok (
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
            placeHolder = "Panjang Rok",
            value = uiState.panjangRok,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangRok(it))}
        ) { }
    }
}