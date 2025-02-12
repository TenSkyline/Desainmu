package com.example.desainmu.presentation.dashboard.components

import androidx.compose.runtime.Composable
import com.example.desainmu.presentation.dashboard.orders.DashboardTab

@Composable
fun DashboardTabItem(item: OrderItemModel, selectedTab: DashboardTab) {
    when (selectedTab) {
        is DashboardTab.Order -> OrderItemView(item = item, onClick = { })
        DashboardTab.Delayed -> DelayedItemView(item = item, onClick = { })
        DashboardTab.History -> HistoryItemView(item = item, onClick = { })
    }
}