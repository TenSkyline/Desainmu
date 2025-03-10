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
internal fun MeasurementKemejaLView(
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState
) {
    Row {
        KemejaLBadan(
            modifier = Modifier.weight(1f),
            onEvent = onEvent,
            uiState = uiState
        )
        Spacer(modifier = Modifier.size(16.dp))
        KemejaLengan(
            modifier = Modifier.weight(1f),
            onEvent = onEvent,
            uiState = uiState
        )
    }
}

@Composable
internal fun MeasurementKemejaPView(
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState
) {
    Row {
        KemejaPBadan(
            modifier = Modifier.weight(1f),
            onEvent = onEvent,
            uiState = uiState
        )
        Spacer(modifier = Modifier.size(16.dp))
        KemejaLengan(
            modifier = Modifier.weight(1f),
            onEvent = onEvent,
            uiState = uiState)
    }
}

@Composable
fun KemejaLBadan (
    modifier: Modifier,
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState) {
    Column (modifier = modifier) {
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
            placeHolder = "Lebar Dada",
            value = uiState.lebarDada,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LebarDada(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Seluruh Bahu",
            value = uiState.panjangSeluruhBahu,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangSeluruhBahu(it))}
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
            placeHolder = "Panjang Baju",
            value = uiState.panjangBaju,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangBaju(it))}
        ) { }
    }
}

@Composable
fun KemejaPBadan (
    modifier: Modifier,
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState) {
    Column (modifier = modifier) {
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
            placeHolder = "Lebar Dada",
            value = uiState.lebarDada,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LebarDada(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Seluruh Bahu",
            value = uiState.panjangSeluruhBahu,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangSeluruhBahu(it))}
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
            placeHolder = "Panjang Baju",
            value = uiState.panjangBaju,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangBaju(it))}
        ) { }
    }
}

@Composable
fun KemejaLengan (
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
            placeHolder = "Lebar Lengan",
            value = uiState.lebarLengan,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LebarLengan(it))}
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
        CustomOutlinedTextFieldNumber(
            placeHolder = "Ban Tangan",
            value = uiState.banTangan,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.BanTangan(it))}
        ) { }
    }
}