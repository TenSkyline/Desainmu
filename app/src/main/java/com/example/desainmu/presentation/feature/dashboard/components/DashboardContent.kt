package com.example.desainmu.presentation.feature.dashboard.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.DashboardTab
import com.example.desainmu.presentation.feature.dashboard.DashboardEvent
import com.example.desainmu.presentation.feature.dashboard.DashboardState


@Composable
internal fun DashboardContent(
    padding: PaddingValues,
    onEvent: (DashboardEvent) -> Unit,
    uiState: DashboardState,
    ) {
    Column(
        modifier = Modifier
            .padding(padding)
            .padding(horizontal = 16.dp)
    ) {
        SelectCategoryTabView(onEvent, uiState)

    }
}

@Composable
private fun SelectCategoryTabView(
    onEvent: (DashboardEvent) -> Unit,
    uiState: DashboardState
) {
    Column(modifier = Modifier.fillMaxSize()) {
        DashboardTabRow(
            selectedTabIndex = uiState.selectedTab,
            onTabSelected = { index ->
                onEvent(DashboardEvent.SelectedTab(index))
            }
        )
        DashboardTabContent(uiState = uiState, onEvent = onEvent)
    }
}

@Composable
private fun DashboardTabRow(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    TabRow(selectedTabIndex = selectedTabIndex) {
        DashboardTab.entries.forEachIndexed { index, tab ->
            Tab(
                text = { Text(tab.title) },
                selected = selectedTabIndex == index,
                onClick = {
                    onTabSelected(index)
                }
            )
        }
    }
}

@Composable
private fun DashboardTabContent(
    uiState: DashboardState,
    onEvent: (DashboardEvent) -> Unit
) {
    when (uiState.selectedTab) {
        0 -> {
            // Display data for tab 0
            ItemsList(
                onEvent = onEvent,
                items = uiState.dashboardOrderItems,
                itemType = "order",
                onItemClick = {
                    onEvent.invoke(DashboardEvent.IsDone(it))
                },
                onDeleteClick = { onEvent.invoke(DashboardEvent.Delete(it.id)) },
            )
        }

        1 -> {
            // Display data for tab 1
            ItemsList(
                onEvent = onEvent,
                items = uiState.dashboardDelayedItems,
                itemType = "delayed",
                onItemClick = { onEvent.invoke(DashboardEvent.IsPayed(it)) },
                onDeleteClick = { }
            )
        }
        2 -> {
            // Display data for tab 2
            ItemsList(
                onEvent = onEvent,
                items = uiState.dashboardHistoryItems,
                itemType = "history",
                onItemClick = { },
                onDeleteClick = { }
            )
        }
    }
    if(uiState.isLoading){
        Text(text = "Loading...")
    }
    if(uiState.error != null){
        Text(text = uiState.error)
    }
}

@Composable
private fun ItemsList(
    onEvent: (DashboardEvent) -> Unit,
    items: List<DashboardItemModel>,
    itemType: String,
    onItemClick: (DashboardItemModel) -> Unit,
    onDeleteClick: (DashboardItemModel) -> Unit
) {
    LazyColumn {
        items(items) { item ->
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onEvent.invoke(DashboardEvent.ToItemDetail(item.id))
                    }, // Make the entire item clickable
                shape = RoundedCornerShape(8.dp),
                shadowElevation = 2.dp
            ) {
                when (itemType) {
                    "order" -> OrderItemView(
                        item,
                        onClick = { onItemClick(item) },
                        onDelete = { onDeleteClick(item) }
                    )
                    "delayed" -> DelayedItemView(item,
                        onClick = { onItemClick(item) },
                        onDelete = { onDeleteClick(item) }
                    )
                    "history" -> HistoryItemView(item)
                    else -> Text("Unknown item type", style = MaterialTheme.typography.bodySmall)
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


//@Composable
//fun ItemsList(items: List<DashboardItemModel>){
//    LazyColumn{
//        items(items) { item ->
//            Text(text = item.title)
//        }
//    }
//}


