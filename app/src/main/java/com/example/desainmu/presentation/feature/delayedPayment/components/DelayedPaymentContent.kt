package com.example.desainmu.presentation.feature.delayedPayment.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.unit.dp
import com.example.desainmu.presentation.feature.dashboard.components.DelayedItemView
import com.example.desainmu.model.ItemModel
import com.example.desainmu.presentation.feature.delayedPayment.DelayedPaymentEvent
import com.example.desainmu.presentation.feature.delayedPayment.DelayedPaymentState

@Composable
internal fun DelayedPaymentContent(
    innerPadding: PaddingValues,
    uiState: DelayedPaymentState,
    filteredList: List<ItemModel>,
    onEvent: (DelayedPaymentEvent) -> Unit,
    focusManager: FocusManager,
    context: Context
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        if (uiState.isSearchActive) {
            DelayedPaymentSearchTextField(
                searchQuery = uiState.searchQuery,
                onSearchQueryChanged = { onEvent(DelayedPaymentEvent.SearchItem(it)) },
                focusManager = focusManager,
                context = context
            )
        }
        DelayedPaymentList(filteredList = filteredList)
    }
}

@Composable
private fun DelayedPaymentList(filteredList: List<ItemModel>) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 24.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (filteredList.isNotEmpty()) {
            items(filteredList) { item ->
                DelayedItemView(item = item, onClick = {
                    // Handle the click event for this specific item
                    // You can add navigation or other actions here
                })
            }
        } else {
            item {
                Text("Data tidak ditemukan")
            }
        }
    }
}