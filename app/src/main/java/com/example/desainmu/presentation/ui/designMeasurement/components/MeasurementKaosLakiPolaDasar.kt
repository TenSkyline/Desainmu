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
internal fun MeasurementKaosLakiPolaDasarView(
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
            placeHolder = "Lingkar Badan",
            value = uiState.lingkarBadan,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LingkarBadan(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Seluruh Bahu",
            value = uiState.panjangSeluruhBahu,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangSeluruhBahu(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Panjang Baju",
            value = uiState.panjangBaju,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangBaju(it))}
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
            placeHolder = "Panjang Lengan",
            value = uiState.panjangLengan,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangLengan(it))}
        ) { }
        CustomOutlinedTextFieldNumber(
            placeHolder = "Lebar Lengan Panjang",
            value = uiState.lebarLengan,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LebarLengan(it))}
        ) { }
//        CustomOutlinedTextFieldNumber(
//            placeHolder = "Panjang Lengan Pendek",
//            value = uiState.panjangLenganPendek,
//            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangLenganPendek(it))}
//        ) { }
//        CustomOutlinedTextFieldNumber(
//            placeHolder = "Lebar Lengan Pendek",
//            value = uiState.lebarLenganPendek,
//            onValueChange = {onEvent.invoke(DesignMeasurementEvent.LebarLenganPendek(it))}
//        ) { }
    }
}
