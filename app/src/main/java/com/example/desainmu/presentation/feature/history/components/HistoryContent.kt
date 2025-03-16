package com.example.desainmu.presentation.feature.history.components

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
import com.example.desainmu.presentation.feature.dashboard.components.HistoryItemView
import com.example.desainmu.model.ItemModel
import com.example.desainmu.presentation.feature.history.HistoryEvent
import com.example.desainmu.presentation.feature.history.HistoryState

@Composable
    internal fun HistoryContent(
    innerPadding: PaddingValues,
    uiState: HistoryState,
    filteredList: List<ItemModel>,
    onEvent: (HistoryEvent) -> Unit,
    focusManager: FocusManager,
    context: Context
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        if (uiState.isSearchActive) {
            HistoryTextField(
                searchQuery = uiState.searchQuery,
                onSearchQueryChanged = { onEvent(HistoryEvent.SearchItem(it)) },
                focusManager = focusManager,
                context = context
            )
        }
        HistoryList(filteredList = filteredList)
    }
}

@Composable
private fun HistoryList(filteredList: List<ItemModel>) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 24.dp, horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (filteredList.isNotEmpty()) {
            items(filteredList) { item ->
                HistoryItemView(item = item)
            }
        } else {
            item {
                Text("Data tidak ditemukan")
            }
        }
    }
}