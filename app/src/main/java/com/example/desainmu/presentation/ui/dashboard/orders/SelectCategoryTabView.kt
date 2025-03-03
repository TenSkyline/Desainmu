package com.example.desainmu.presentation.ui.dashboard.orders

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.desainmu.presentation.ui.dashboard.DashboardEvent
import com.example.desainmu.presentation.ui.dashboard.DashboardState
import com.example.desainmu.presentation.ui.dashboard.DashboardTab
import com.example.desainmu.presentation.ui.dashboard.components.DashboardTabContent
import com.example.desainmu.presentation.ui.dashboard.components.DashboardTabRow

@Composable
fun SelectCategoryTabView(
    onEvent: (DashboardEvent) -> Unit,
    uiState: DashboardState
) {
    val tabs = listOf(DashboardTab.Order, DashboardTab.Delayed, DashboardTab.History)
//    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        DashboardTabRow(
            tabs = tabs,
//            selectedTabIndex = selectedTabIndex,
            selectedTabIndex = tabs.indexOf(uiState.selectedTab),
            onTabSelected = { index ->
                onEvent(DashboardEvent.SelectedTab(tabs[index]))
//                selectedTabIndex = it

            }
        )
        DashboardTabContent(
//            selectedTab = tabs[selectedTabIndex]
            selectedTab = uiState.selectedTab
        )
    }
}