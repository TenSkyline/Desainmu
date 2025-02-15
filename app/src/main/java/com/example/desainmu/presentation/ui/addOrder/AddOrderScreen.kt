package com.example.desainmu.presentation.ui.addOrder

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.theme.DesainmuTheme
import com.example.desainmu.presentation.ui.addOrder.components.AddOrderContent
import com.example.desainmu.presentation.ui.addOrder.components.AddOrderTopBar

sealed class AddOrderNav {
    data class ToMeasurement(val design: Design) : AddOrderNav()
    data object NavigateUp : AddOrderNav()
    data class OnEvent(val event: AddOrderEvent) : AddOrderNav()
    data class UiState (val uiState: AddOrderState): AddOrderNav()
}

@Composable
internal fun AddOrderRoute(navigateToMeasurement: (Design) -> Unit, navigateUp: () -> Unit = {}) {
    val viewModel: AddOrderViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val eventVariation: (AddOrderNav) -> Unit = { nav ->
        when (nav) {
            is AddOrderNav.ToMeasurement -> navigateToMeasurement(nav.design)
            is AddOrderNav.NavigateUp -> navigateUp()
            is AddOrderNav.OnEvent -> viewModel.handleEvent(nav.event)
            is AddOrderNav.UiState -> viewModel.uiState
        }
    }
//    AddOrderScreen(
//        onClickDesign = navigateToMeasurement,
//        navigateUp,
//        onEvent = viewModel::handleEvent,
//        uiState
//    )
    AddOrderScreen(navigationEvent = eventVariation, uiState = uiState)
}

@Composable
fun AddOrderScreen(
    navigationEvent: (AddOrderNav) -> Unit,
    uiState: AddOrderState
//    onClickDesign: (Design) -> Unit,
//    navigateUp: () -> Unit = {},
//    onEvent: (AddOrderEvent) -> Unit,
//    uiState: AddOrderState
) {
    Scaffold(
        topBar = { AddOrderTopBar(navigationEvent) },
        content = { padding -> AddOrderContent(padding, navigationEvent, uiState) }
    )
}

@Preview
@Composable
private fun AddOrderScreenPreview() {
    DesainmuTheme {

    }
}