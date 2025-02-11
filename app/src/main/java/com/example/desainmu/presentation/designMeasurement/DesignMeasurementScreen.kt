package com.example.desainmu.presentation.designMeasurement


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.designMeasurement.components.DesignMeasurementItemView
import com.example.desainmu.ui.component.CustomIconButton
import com.example.desainmu.ui.theme.DesainmuTheme

@Composable
internal fun AddOrderMeasurementRoute(design: Design, navigateUp: () -> Unit) {
    AddOrderMeasurementScreen(design = design, navigateUp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddOrderMeasurementScreen(design: Design, navigateUp: () -> Unit = {}) {
    val selectedDesign by remember { mutableStateOf(design) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Pengukuran ${design.title}")
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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
            ) {
                LazyColumn (
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 72.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    item {
                        DesignMeasurementItemView(selectedDesign = selectedDesign)
                    }
                }
                ElevatedButton(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
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