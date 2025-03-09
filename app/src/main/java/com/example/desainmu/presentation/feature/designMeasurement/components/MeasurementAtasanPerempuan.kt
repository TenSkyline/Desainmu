package com.example.desainmu.presentation.feature.designMeasurement.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.presentation.design.components.CustomOutlinedTextFieldNumber
import com.example.desainmu.presentation.feature.designMeasurement.DesignMeasurementEvent
import com.example.desainmu.presentation.feature.designMeasurement.DesignMeasurementState

@Composable
internal fun MeasurementAtasanPView(
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState
) {
    Row {
        AtasanPBadan(
            modifier = Modifier.weight(1f),
            onEvent = onEvent,
            uiState = uiState)
        Spacer(modifier = Modifier.size(16.dp))
        AtasanPLengan(
            modifier = Modifier.weight(1f),
            onEvent = onEvent,
            uiState = uiState)
    }
}

@Composable
fun AtasanPBadan (
    modifier: Modifier,
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState) {
    Column(modifier = modifier) {
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Leher",
            value = uiState.lingkarLeher,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LingkarLeher(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Badan",
            value = uiState.lingkarBadan,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LingkarBadan(it))}
        ) { }
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
            placeHolder = "Panjang Dada",
            value = uiState.panjangDada,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangDada(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lebar Dada",
            value = uiState.lebarDada,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LebarDada(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Jarak Bustier",
            value = uiState.jarakBustier,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.JarakBustier(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Tinggi Bustier",
            value = uiState.tinggiBustier,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.TinggiBustier(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Seluruh Bahu",
            value = uiState.panjangSeluruhBahu,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangSeluruhBahu(it))}
        ) { }
//        CustomOutlinedTextFieldNumber(
//            placeHolder = "Panjang Seluruh Bahu",
//            value = uiState.panjangSeluruhBahu,
//            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangSeluruhBahu(it))}
//        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Punggung",
            value = uiState.panjangPunggung,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangPunggung(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lebar Punggung",
            value = uiState.lebarPunggung,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LebarPunggung(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Kerung Lengan",
            value = uiState.kerungLengan,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.KerungLengan(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Sisi Badan",
            value = uiState.sisiBadan,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.SisiBadan(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Baju",
            value = uiState.panjangBaju,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangBaju(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Gamis",
            value = uiState.panjangGamis,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangGamis(it))}
        ) { }
    }
}

@Composable
fun AtasanPLengan (
    modifier: Modifier,
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState) {
    Column (modifier = modifier) {
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Lengan",
            value = uiState.panjangLengan,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangLengan(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lingkar Bawah",
            value = uiState.lingkarBawah,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LingkarBawah(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Siku",
            value = uiState.panjangSiku,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangSiku(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lebar Siku",
            value = uiState.lebarSiku,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LebarSiku(it))}
        ) { }
    }
}