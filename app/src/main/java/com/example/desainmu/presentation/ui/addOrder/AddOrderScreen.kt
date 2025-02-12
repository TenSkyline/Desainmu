package com.example.desainmu.presentation.ui.addOrder

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.theme.DesainmuTheme
import com.example.desainmu.presentation.ui.addOrder.components.AddOrderContent
import com.example.desainmu.presentation.ui.addOrder.components.AddOrderTopBar

@Composable
internal fun AddOrderRoute(navigateToMeasurement: (Design) -> Unit, navigateUp: () -> Unit = {}) {
    val viewModel: AddOrderViewModel = viewModel()
    AddOrderScreen(onClickDesign = navigateToMeasurement, navigateUp)
}

@Composable
internal fun AddOrderScreen(onClickDesign: (Design) -> Unit, navigateUp: () -> Unit = {}) {
    Scaffold(
        topBar = { AddOrderTopBar(navigateUp) },
        content = { padding -> AddOrderContent(padding, onClickDesign) }
    )
}

@Preview
@Composable
private fun AddOrderScreenPreview() {
    DesainmuTheme {

    }
}