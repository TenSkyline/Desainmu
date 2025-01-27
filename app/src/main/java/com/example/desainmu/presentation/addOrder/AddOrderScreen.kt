package com.example.desainmu.presentation.addOrder

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.addOrder.components.AddOrderItemView
import com.example.desainmu.ui.component.CustomIconButton
import com.example.desainmu.ui.theme.DesainmuTheme

@Composable
internal fun AddOrderRoute(navigateToMeasurement: (Design) -> Unit) {
    val viewModel: AddOrderViewModel = viewModel()
    AddOrderScreen(navigateToMeasurement)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AddOrderScreen(onClickDesign: (Design) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Tambah Pesanan")
                },
                navigationIcon = {
                    CustomIconButton(
                        icon = Icons.Default.Menu,
                        onClick = { }
                    )
                },
                actions = {
                    CustomIconButton(
                        icon = Icons.AutoMirrored.Filled.ArrowBack,
                        onClick = { }
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
                AddOrderItemView(onClickDesign = {onClickDesign.invoke(it)})
                ElevatedButton(
                    onClick = {

                    },
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
private fun AddOrderScreenPreview() {
    DesainmuTheme {

    }
}