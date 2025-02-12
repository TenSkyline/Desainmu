package com.example.desainmu.presentation.ui.designMeasurement


import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.theme.DesainmuTheme
import com.example.desainmu.presentation.ui.designMeasurement.components.AddOrderMeasurementContent
import com.example.desainmu.presentation.ui.designMeasurement.components.AddOrderMeasurementTopBar

@Composable
internal fun AddOrderMeasurementRoute(design: Design, navigateUp: () -> Unit) {
    AddOrderMeasurementScreen(design = design, navigateUp)
}

@Composable
internal fun AddOrderMeasurementScreen(design: Design, navigateUp: () -> Unit = {}) {
    Scaffold(
        topBar = { AddOrderMeasurementTopBar(design, navigateUp) },
        content = { padding -> AddOrderMeasurementContent(padding, design) }
    )
}

@Preview
@Composable
private fun AddOrderMeasurementScreenPreview() {
    DesainmuTheme {
        AddOrderMeasurementScreen(design = Design.Kaos)
    }
}