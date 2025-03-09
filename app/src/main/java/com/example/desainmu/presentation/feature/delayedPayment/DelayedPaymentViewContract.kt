package com.example.desainmu.presentation.feature.delayedPayment

data class DelayedPaymentState (
    val searchQuery: String = "",
    val isSearchActive: Boolean = false,
//    val filteredList: List<OrderItemModel> = emptyList()
)

sealed class DelayedPaymentEvent {
    data class SearchItem (val query: String) : DelayedPaymentEvent()
    data class UpdateSearchActive (val isActive: Boolean) : DelayedPaymentEvent()
    data object NavigateUp: DelayedPaymentEvent()
}

sealed class DelayedPaymentEffect {
    data object NavigateUp: DelayedPaymentEffect()
}