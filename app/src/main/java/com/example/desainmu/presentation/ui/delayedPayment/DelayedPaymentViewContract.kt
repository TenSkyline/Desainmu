package com.example.desainmu.presentation.ui.delayedPayment

import com.example.desainmu.presentation.ui.dashboard.components.OrderItemModel

data class DelayedPaymentState (
    val searchQuery: String = "",
    val isSearchActive: Boolean = false,
    val filteredList: List<OrderItemModel> = emptyList()
)

sealed class DelayedPaymentEvent {
    data class SearchItem (val query: String) : DelayedPaymentEvent()
    data class UpdateSearchActive (val isActive: Boolean) : DelayedPaymentEvent()
}