package com.example.desainmu.presentation.feature.dashboard

import com.example.desainmu.data.database.model.ItemTable
import com.example.desainmu.model.DashboardTab
import com.example.desainmu.model.ItemModel


data class DashboardState (
    val selectedTab: Int = DashboardTab.Order.ordinal,
    val categories: List<ItemTable> = emptyList(),
    val items: List<ItemModel> = emptyList(),
    val dashboardOrderItems: List<ItemModel> = emptyList(),
    val dashboardDelayedItems: List<ItemModel> = emptyList(),
    val dashboardHistoryItems: List<ItemModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

sealed class DashboardEffect {
    data object ToDelayedPayment : DashboardEffect()
    data object ToHistory : DashboardEffect()
    data object ToAddOrder : DashboardEffect()
}

sealed class DashboardEvent {
    data object ToDelayed : DashboardEvent()
    data object ToHistory : DashboardEvent()
    data object ToAddOrder : DashboardEvent()
    data class SelectedTab(val selectedTab: Int) : DashboardEvent()
    data class ItemClickedDone(val item: ItemModel) : DashboardEvent()
    data class ItemClickedPayed(val item: ItemModel) : DashboardEvent()
    data class Delete(val id: Int) : DashboardEvent()
}
