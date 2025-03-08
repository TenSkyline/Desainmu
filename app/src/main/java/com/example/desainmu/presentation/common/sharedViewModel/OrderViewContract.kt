package com.example.desainmu.presentation.common.sharedViewModel

import com.example.desainmu.data.database.ItemTable
import com.example.desainmu.model.SortType


data class OrderState(
    val orders: List<ItemTable> = emptyList(),
    val isEntryValid: Boolean = false,
    val sortType: SortType = SortType.TITLE_NAME
)

sealed class OrderEvent {
//    data object SaveOrder: OrderEvent()
    data class SortOrder(val sortType: SortType) : OrderEvent()
    data class DeleteOrder(val order: ItemTable) : OrderEvent()
}