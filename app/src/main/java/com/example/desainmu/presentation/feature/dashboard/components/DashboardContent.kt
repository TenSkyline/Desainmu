package com.example.desainmu.presentation.feature.dashboard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.DashboardTab
import com.example.desainmu.presentation.feature.dashboard.DashboardEvent
import com.example.desainmu.presentation.feature.dashboard.DashboardState


@Composable
internal fun DashboardContent(
    padding: PaddingValues,
    onEvent: (DashboardEvent) -> Unit,
    uiState: DashboardState
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
                onEvent(DashboardEvent.SelectedTab(uiState.selectedTab))
            }
        )
//        DashboardTabContent(
//            selectedTab = uiState.selectedTab
//        )
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
private fun DashboardTabContent(selectedTab: DashboardTab) {
    val listState = rememberLazyListState()
    LaunchedEffect(selectedTab) {
        listState.animateScrollToItem(0)
    }
    LazyColumn(
        contentPadding = PaddingValues(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        state = listState
    ) {
//        items(selectedTab.data) { item ->
//            DashboardTabItem(item = item, selectedTab = selectedTab)
//        }
    }
}

@Composable
private fun DashboardTabItem(item: OrderItemModel, selectedTab: DashboardTab) {
    when (selectedTab) {
        DashboardTab.Order -> OrderItemView(item = item, onClick = { })
        DashboardTab.Delayed -> DelayedItemView(item = item, onClick = { })
        DashboardTab.History -> HistoryItemView(item = item)
    }
}