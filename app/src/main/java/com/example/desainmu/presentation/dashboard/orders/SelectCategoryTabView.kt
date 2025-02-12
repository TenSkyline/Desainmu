package com.example.desainmu.presentation.dashboard.orders

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.desainmu.presentation.dashboard.components.DashboardTabContent
import com.example.desainmu.presentation.dashboard.components.DashboardTabRow

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