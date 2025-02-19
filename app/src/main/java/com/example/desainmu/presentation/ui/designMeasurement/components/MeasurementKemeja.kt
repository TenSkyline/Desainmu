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
            placeHolder = "Panjang Bahu",
            value = uiState.panjangBahu,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangBahu(it))}
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
            placeHolder = "Panjang Bahu",
            value = uiState.panjangBahu,
            onValueChange = {onEvent.invoke(DesignMeasurementEvent.PanjangBahu(it))}
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