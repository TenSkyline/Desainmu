package com.example.desainmu.presentation.feature.history

import com.example.desainmu.model.ItemModel


data class HistoryState (
    val searchQuery: String = "",
    val isSearchActive: Boolean = false,
//    val filteredList: List<OrderItemModel> = emptyList()
    val items: List<ItemModel> = emptyList(),
)

sealed class HistoryEvent {
    data class SearchItem (val query: String) : HistoryEvent()
    data class UpdateSearchActive (val isActive: Boolean) : HistoryEvent()
    data object NavigateUp: HistoryEvent()
}

sealed class HistoryEffect {
    data object NavigateUp: HistoryEffect()
}