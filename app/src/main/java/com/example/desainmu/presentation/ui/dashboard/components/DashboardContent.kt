package com.example.desainmu.presentation.ui.dashboard.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.presentation.ui.dashboard.DashboardEvent
import com.example.desainmu.presentation.ui.dashboard.DashboardState
import com.example.desainmu.presentation.ui.dashboard.orders.SelectCategoryTabView

@Composable
fun DashboardContent(
    padding: PaddingValues,
    onEvent: (DashboardEvent) -> Unit,
    uiState: DashboardState
    ) {
    Column(
        modifier = Modifier
            .padding(padding)
            .padding(horizontal = 16.dp)
    ) {
        SelectCategoryTabView(onEvent, uiState)
    }
}