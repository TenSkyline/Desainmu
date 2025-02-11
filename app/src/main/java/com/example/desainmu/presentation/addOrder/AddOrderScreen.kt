package com.example.desainmu.presentation.addOrder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.addOrder.components.AddOrderItemView
import com.example.desainmu.presentation.designMeasurement.components.DesignMeasurementItemView
import com.example.desainmu.ui.component.CustomIconButton
import com.example.desainmu.ui.theme.DesainmuTheme

@Composable
internal fun AddOrderRoute(navigateToMeasurement: (Design) -> Unit, navigateUp: () -> Unit = {}) {
    val viewModel: AddOrderViewModel = viewModel()
    AddOrderScreen(onClickDesign = navigateToMeasurement, navigateUp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddOrderScreen(onClickDesign: (Design) -> Unit, navigateUp: () -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Tambah Pesanan")
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
            var selectedDesign by remember { mutableStateOf(Design.Kaos)}
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
                        AddOrderItemView(selectedDesign = selectedDesign, onSelectedDesign = {selectedDesign = Design.valueOf(it)})
                    }
                }
                ElevatedButton(
                    onClick = {
                        onClickDesign.invoke(selectedDesign)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(alignment = Alignment.BottomCenter)
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
private fun AddOrderScreenPreview() {
    DesainmuTheme {

    }
}