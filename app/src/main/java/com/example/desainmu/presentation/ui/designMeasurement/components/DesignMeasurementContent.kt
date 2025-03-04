package com.example.desainmu.presentation.ui.designMeasurement.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.Design
import com.example.desainmu.model.DesignInput
import com.example.desainmu.presentation.ui.designMeasurement.DesignMeasurementEvent
import com.example.desainmu.presentation.ui.designMeasurement.DesignMeasurementState

@Composable
internal fun AddOrderMeasurementContent(
    padding: PaddingValues,
    selectedDesign: Design,
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
    ) {
        AddOrderMeasurementList(
            selectedDesign = selectedDesign,
            onEvent = onEvent,
            uiState = uiState
        )
        ElevatedButton(
            onClick = {
                DesignInput.dataDesign = uiState
                onEvent.invoke(DesignMeasurementEvent.ToResult(design = selectedDesign))
            },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text("Hasil Pengukuran")
        }
    }
}

@Composable
private fun AddOrderMeasurementList(
    selectedDesign: Design,
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 72.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            DesignMeasurementItemView(
                selectedDesign = selectedDesign,
                onEvent = onEvent,
                uiState = uiState
            )
        }
    }
}

@Composable
private fun DesignMeasurementItemView(
    selectedDesign: Design,
    onEvent: (DesignMeasurementEvent) -> Unit,
    uiState: DesignMeasurementState
) {
    when (selectedDesign) {
        Design.KaosLakiPolaDasar -> {
            MeasurementKaosLakiPolaDasarView(onEvent = onEvent, uiState = uiState)
        }

        Design.Celana -> {
            MeasurementCelanaView(onEvent = onEvent, uiState = uiState)
        }

        Design.KemejaL -> {
            MeasurementKemejaLView(onEvent = onEvent, uiState = uiState)
        }

        Design.KemejaP -> {
            MeasurementKemejaPView(onEvent = onEvent, uiState = uiState)
        }

        Design.Rok -> {
            MeasurementRokView(onEvent = onEvent, uiState = uiState)
        }

        Design.AtasanPerempuan -> {
            MeasurementAtasanPView(onEvent = onEvent, uiState = uiState)
        }
    }
}