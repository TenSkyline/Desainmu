package com.example.desainmu.presentation.ui.dashboard.components

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.desainmu.presentation.ui.dashboard.DashboardTab

@Composable
fun DashboardTabRow(
    tabs: List<DashboardTab>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    TabRow(selectedTabIndex = selectedTabIndex) {
        tabs.forEachIndexed { index, tab ->
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