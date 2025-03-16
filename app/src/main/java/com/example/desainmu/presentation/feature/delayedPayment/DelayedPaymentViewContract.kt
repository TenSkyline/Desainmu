package com.example.desainmu.presentation.feature.delayedPayment

import com.example.desainmu.model.ItemModel

data class DelayedPaymentState (
    val searchQuery: String = "",
    val isSearchActive: Boolean = false,
//    val filteredList: List<OrderItemModel> = emptyList()
    val items: List<ItemModel> = emptyList(),
)

sealed class DelayedPaymentEvent {
    data class SearchItem (val query: String) : DelayedPaymentEvent()
    data class UpdateSearchActive (val isActive: Boolean) : DelayedPaymentEvent()
    data object NavigateUp: DelayedPaymentEvent()
}

sealed class DelayedPaymentEffect {
    data object NavigateUp: DelayedPaymentEffect()
}