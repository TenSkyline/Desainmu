package com.example.desainmu.presentation.ui.dashboard

import com.example.desainmu.data.database.ItemTable
import com.example.desainmu.model.DashboardTab


data class DashboardState (
//    val selectedTab: DashboardTab = DashboardTab.Order,
    val selectedTab: Int = DashboardTab.Order.ordinal,
    val categories: List<ItemTable> = emptyList(),
//    val sortType: SortType = SortType.TITLE_NAME
)

sealed class DashboardEvent {
    data object ToDelayed : DashboardEvent()
    data object ToHistory : DashboardEvent()
    data object ToAddOrder : DashboardEvent()
    data class SelectedTab(val selectedTab: Int) : DashboardEvent()
}

sealed class DashboardEffect {
    data object ToDelayedPayment : DashboardEffect()
    data object ToHistory : DashboardEffect()
    data object ToAddOrder : DashboardEffect()
}

//sealed class DashboardTab(val title: String, val data: Flow<List<Item>>) {
//    data class Order(val orderItems: Flow<List<Item>>) : DashboardTab("Pesanan", orderItems)
//    data class Delayed(val delayedItems: Flow<List<Item>>) : DashboardTab("Belum Bayar", delayedItems)
//    data class History(val historyItems: Flow<List<Item>>) : DashboardTab("Riwayat", historyItems)
//}

//sealed class DashboardTab(val title: String, val data: List<OrderItemModel>) {
//    data object Order : DashboardTab("Pesanan", dummyValueOrder)
//    data object Delayed : DashboardTab("Belum Bayar", dummyValueDelayed)
//    data object History : DashboardTab("Riwayat", dummyValueHistory)
//}