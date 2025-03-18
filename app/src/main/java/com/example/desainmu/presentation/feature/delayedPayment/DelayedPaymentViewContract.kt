package com.example.desainmu.presentation.feature.delayedPayment

import com.example.desainmu.presentation.feature.dashboard.components.DashboardItemModel

data class DelayedPaymentState (
    val searchQuery: String = "",
    val isSearchActive: Boolean = false,
    val items: List<DashboardItemModel> = emptyList(),
)

sealed class DelayedPaymentEffect {
    data object NavigateUp: DelayedPaymentEffect()
    data class ToItemDetail(val itemId: Int) : DelayedPaymentEffect()
}

sealed class DelayedPaymentEvent {
    data class SearchItem (val query: String) : DelayedPaymentEvent()
    data class UpdateSearchActive (val isActive: Boolean) : DelayedPaymentEvent()
    data object NavigateUp: DelayedPaymentEvent()
    data class ToItemDetail(val itemId: Int) : DelayedPaymentEvent()
}
