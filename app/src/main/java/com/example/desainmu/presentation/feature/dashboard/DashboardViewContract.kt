package com.example.desainmu.presentation.feature.dashboard

import com.example.desainmu.data.database.model.ItemTable
import com.example.desainmu.model.DashboardTab
import com.example.desainmu.presentation.feature.dashboard.components.DashboardItemModel


data class DashboardState(
    val selectedTab: Int = DashboardTab.Order.ordinal,
    val categories: List<ItemTable> = emptyList(),
    val items: List<DashboardItemModel> = emptyList(),
    val dashboardOrderItems: List<DashboardItemModel> = emptyList(),
    val dashboardDelayedItems: List<DashboardItemModel> = emptyList(),
    val dashboardHistoryItems: List<DashboardItemModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

sealed class DashboardEffect {
    data object ToDelayedPayment : DashboardEffect()
    data object ToHistory : DashboardEffect()
    data object ToAddOrder : DashboardEffect()
    data class ToItemDetail(val itemId: Int) : DashboardEffect()
}

sealed class DashboardEvent {
    data object ToDelayed : DashboardEvent()
    data object ToHistory : DashboardEvent()
    data object ToAddOrder : DashboardEvent()
    data class ToItemDetail(val itemId: Int) : DashboardEvent()
    data class SelectedTab(val selectedTab: Int) : DashboardEvent()
    data class IsDone(val item: DashboardItemModel) : DashboardEvent()
    data class IsPayed(val item: DashboardItemModel) : DashboardEvent()
    data class Delete(val itemId: Int) : DashboardEvent()
}
