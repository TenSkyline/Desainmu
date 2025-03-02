package com.example.desainmu.presentation.ui.designMeasurement.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.common.sharedComponents.CustomIconButton
import com.example.desainmu.presentation.ui.addOrder.AddOrderEvent
import com.example.desainmu.presentation.ui.designMeasurement.DesignMeasurementEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesignMeasurementTopBar(design: Design, onEvent: (DesignMeasurementEvent) -> Unit,) {
    TopAppBar(
        title = { Text("Pengukuran ${design.title}") },
        navigationIcon = {
            CustomIconButton(
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                onClick = { onEvent.invoke(DesignMeasurementEvent.NavigateUp) }
            )
        }
    )
}