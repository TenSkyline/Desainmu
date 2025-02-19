package com.example.desainmu.presentation.ui.designMeasurement.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.presentation.common.sharedComponents.CustomOutlinedTextFieldNumber
import com.example.desainmu.presentation.ui.designMeasurement.DesignMeasurementEvent
import com.example.desainmu.presentation.ui.designMeasurement.DesignMeasurementState

@Composable
internal fun MeasurementKaosView(
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState
) {
    Row {
        KaosBadan(
            modifier = Modifier.weight(1f),
            onEvent = onEvent,
            uiState = uiState
        )
        Spacer(modifier = Modifier.size(16.dp))
        KaosLengan(
            modifier = Modifier.weight(1f),
            onEvent = onEvent,
            uiState = uiState
        )
    }
}

@Composable
fun KaosBadan(
    modifier: Modifier,
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState
) {
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
            placeHolder = "Panjang Seluruhnya",
            value = uiState.panjangSeluruhnya,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangSeluruhnya(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Bahu",
            value = uiState.panjangBahu,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangBahu(it))}
        ) { }
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
    }
}

@Composable
fun KaosLengan(
    modifier: Modifier,
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState) {
    Column(modifier = modifier) {
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Lengan Panjang",
            value = uiState.panjangLenganPanjang,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangLenganPanjang(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lebar Lengan Panjang",
            value = uiState.lebarLenganPanjang,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LebarLenganPanjang(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Lengan Pendek",
            value = uiState.panjangLenganPendek,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangLenganPendek(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lebar Lengan Pendek",
            value = uiState.lebarLenganPendek,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LebarLenganPendek(it))}
        ) { }
    }
}
