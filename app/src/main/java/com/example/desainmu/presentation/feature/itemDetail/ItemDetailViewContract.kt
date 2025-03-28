package com.example.desainmu.presentation.feature.itemDetail

import com.example.desainmu.presentation.feature.itemDetail.components.ItemDetailModel

data class ItemDetailState(
    val item: ItemDetailModel? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val showDeleteConfirmation: Boolean = false
)

sealed class ItemDetailEffect {
    data object NavigateUp : ItemDetailEffect()

}

sealed class ItemDetailEvent {
    data object NavigateUp : ItemDetailEvent()
    data object ShowDeleteConfirmation : ItemDetailEvent()
    data object DismissDeleteConfirmation : ItemDetailEvent()
    data object Delete : ItemDetailEvent()
}