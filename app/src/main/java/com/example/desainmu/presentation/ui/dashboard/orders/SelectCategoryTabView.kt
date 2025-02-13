package com.example.desainmu.presentation.ui.dashboard.orders

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.presentation.ui.dashboard.components.DashboardTabContent
import com.example.desainmu.presentation.ui.dashboard.components.DashboardTabItem
import com.example.desainmu.presentation.ui.dashboard.components.DashboardTabRow
import com.example.desainmu.presentation.ui.dashboard.components.DelayedItemView

@Composable
fun SelectCategoryTabView() {
    val tabs = listOf(DashboardTab.Order, DashboardTab.Delayed, DashboardTab.History)
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        DashboardTabRow(
            tabs = tabs,
            selectedTabIndex = selectedTabIndex,
            onTabSelected = { selectedTabIndex = it }
        )
        DashboardTabContent(
            selectedTab = tabs[selectedTabIndex]
        )
    }
}