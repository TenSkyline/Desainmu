package com.example.desainmu.presentation.feature.dashboard.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
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
//                onEvent(DashboardEvent.SelectedTab(uiState.selectedTab))
                onEvent(DashboardEvent.SelectedTab(index))
            }
        )
        DashboardTabContent(uiState = uiState)
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
private fun DashboardTabContent(uiState: DashboardState) {
    when (uiState.selectedTab) {
        0 -> {
            // Display data for tab 0
            ItemsList(
                items = uiState.dashboardOrderItems,
                itemType = "order",
                onItemClick = { }
            )
//            OrderItemView(item = uiState.dashboardOrderItems[0], onClick = {})
        }

        1 -> {
            // Display data for tab 1
            ItemsList(
                items = uiState.dashboardDelayedItems,
                itemType = "delayed",
                onItemClick = { }
            )
//            DelayedItemView(item = uiState.dashboardDelayedItems[1], onClick = {})
        }
        2 -> {
            // Display data for tab 2
            ItemsList(
                items = uiState.dashboardHistoryItems,
                itemType = "history",
                onItemClick = { }
            )
//            HistoryItemView(item = uiState.dashboardHistoryItems[2])
        }
        // ... more cases
        else -> {
            // Display data when selectedTab is not handled
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
fun ItemsList(
    items: List<DashboardItemModel>,
    itemType: String,
    onItemClick: (DashboardItemModel) -> Unit) {

    LazyColumn {
        items(items) { item ->
            Spacer(modifier = Modifier.height(8.dp))
            when (itemType) {
                "order" -> OrderItemView(item, onClick = { onItemClick(item) })
                "delayed" -> DelayedItemView(item, onClick = { onItemClick(item) })
                "history" -> HistoryItemView(item)
                else -> Text("Unknown item type", style = MaterialTheme.typography.bodySmall)
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


