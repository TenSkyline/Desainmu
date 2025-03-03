package com.example.desainmu.presentation.ui.dashboard.components

import androidx.compose.runtime.Composable
import com.example.desainmu.presentation.ui.dashboard.DashboardTab

@Composable
fun DashboardTabItem(item: OrderItemModel, selectedTab: DashboardTab) {
    when (selectedTab) {
        DashboardTab.Order -> OrderItemView(item = item, onClick = { })
        DashboardTab.Delayed -> DelayedItemView(item = item, onClick = { })
        DashboardTab.History -> HistoryItemView(item = item, onClick = { })
    }
}