package com.example.desainmu.presentation.ui.dashboard

import com.example.desainmu.model.Design
import com.example.desainmu.presentation.ui.addOrder.AddOrderEvent
import com.example.desainmu.presentation.ui.dashboard.components.OrderItemModel
import com.example.desainmu.presentation.ui.dashboard.components.dummyValueDelayed
import com.example.desainmu.presentation.ui.dashboard.components.dummyValueHistory
import com.example.desainmu.presentation.ui.dashboard.components.dummyValueOrder


data class DashboardState (
    val selectedTab: DashboardTab = DashboardTab.Order
)

sealed class DashboardEvent {
    data object ToDelayed : DashboardEvent()
    data object ToHistory : DashboardEvent()
    data object ToAddOrder : DashboardEvent()
    data class SelectedTab(val selectedTab: DashboardTab) : DashboardEvent()
}

sealed class DashboardEffect {
    data object ToDelayedPayment : DashboardEffect()
    data object ToHistory : DashboardEffect()
    data object ToAddOrder : DashboardEffect()
}

sealed class DashboardTab(val title: String, val data: List<OrderItemModel>) {
    data object Order : DashboardTab("Pesanan", dummyValueOrder)
    data object Delayed : DashboardTab("Belum Bayar", dummyValueDelayed)
    data object History : DashboardTab("Riwayat", dummyValueHistory)
}