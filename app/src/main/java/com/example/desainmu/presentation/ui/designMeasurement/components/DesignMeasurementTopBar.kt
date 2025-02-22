package com.example.desainmu.presentation.ui.designMeasurement.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.common.sharedComponents.CustomIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DesignMeasurementTopBar(design: Design, navigateUp: () -> Unit) {
    TopAppBar(
        title = { Text("Pengukuran ${design.title}") },
        navigationIcon = {
            CustomIconButton(
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                onClick = { navigateUp.invoke() }
            )
        }
    )
}