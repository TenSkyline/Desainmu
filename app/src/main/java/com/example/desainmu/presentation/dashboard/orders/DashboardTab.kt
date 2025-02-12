package com.example.desainmu.presentation.dashboard.orders

import androidx.compose.runtime.Immutable
import com.example.desainmu.presentation.dashboard.components.OrderItemModel
import com.example.desainmu.presentation.dashboard.components.dummyValueDelayed
import com.example.desainmu.presentation.dashboard.components.dummyValueHistory
import com.example.desainmu.presentation.dashboard.components.dummyValueOrder

@Immutable
sealed class DashboardTab(val title: String, val data: List<OrderItemModel>) {
    data object Order : DashboardTab("Pesanan", dummyValueOrder)
    data object Delayed : DashboardTab("Belum Bayar", dummyValueDelayed)
    data object History : DashboardTab("Riwayat", dummyValueHistory)
}