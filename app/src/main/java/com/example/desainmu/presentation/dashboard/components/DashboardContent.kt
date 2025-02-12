package com.example.desainmu.presentation.dashboard.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.presentation.dashboard.orders.SelectCategoryTabView

@Composable
fun DashboardContent(padding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(padding)
            .padding(horizontal = 16.dp)
    ) {
        SelectCategoryTabView()
    }
}