package com.example.desainmu.presentation.ui.dashboard.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.unit.dp
import com.example.desainmu.presentation.ui.dashboard.DashboardTab

@Composable
fun DashboardTabContent(selectedTab: DashboardTab) {
    val listState = rememberLazyListState()
    LaunchedEffect(selectedTab) {
        listState.animateScrollToItem(0)
    }
    LazyColumn(
        contentPadding = PaddingValues(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        state = listState
    ) {
        items(selectedTab.data) { item ->
            DashboardTabItem(item = item, selectedTab = selectedTab)
        }
    }
}