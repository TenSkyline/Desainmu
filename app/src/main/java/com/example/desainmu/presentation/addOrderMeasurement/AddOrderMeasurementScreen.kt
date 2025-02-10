package com.example.desainmu.presentation.addOrderMeasurement


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.addOrderMeasurement.components.AddOrderMeasurementItemView
import com.example.desainmu.ui.component.CustomIconButton
import com.example.desainmu.ui.theme.DesainmuTheme

@Composable
internal fun AddOrderMeasurementRoute(design: Any, navigateUp: () -> Unit) {
    AddOrderMeasurementScreen(design = design, navigateUp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddOrderMeasurementScreen(design: Any, navigateUp: () -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Pengukuran $design")
                },
                navigationIcon = {
                    CustomIconButton(
                        icon = Icons.AutoMirrored.Filled.ArrowBack,
                        onClick = {navigateUp.invoke()}
                    )
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                AddOrderMeasurementItemView(design = Design.Kaos)
                ElevatedButton(
                    onClick = { },
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(16.dp)
                ) {
                    Text("Berikutnya")
                }
            }
        }
    )
}

@Preview
@Composable
private fun AddOrderMeasurementScreenPreview() {
    DesainmuTheme {
        AddOrderMeasurementScreen(design = Design.Kaos)
    }
}