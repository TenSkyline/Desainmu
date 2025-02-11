package com.example.desainmu.presentation.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.desainmu.presentation.dashboard.components.DelayedItemView
import com.example.desainmu.presentation.dashboard.components.OrderItemModel
import com.example.desainmu.presentation.dashboard.components.OrderItemView
import com.example.desainmu.presentation.dashboard.components.HistoryItemView
import com.example.desainmu.presentation.dashboard.components.dummyValueDelayed
import com.example.desainmu.presentation.dashboard.components.dummyValueHistory
import com.example.desainmu.presentation.dashboard.components.dummyValueOrder
import com.example.desainmu.ui.component.CustomIconButton
import com.example.desainmu.ui.theme.DesainmuTheme
import kotlinx.coroutines.launch

@Composable
internal fun DashboardRoute(navigateToAddOrder: () -> Unit) {
    DashboardScreen(navigateToAddOrder)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DashboardScreen(onClick: () -> Unit = {}) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Halaman Utama")
                },
                navigationIcon = {
                    CustomIconButton(
                        icon = Icons.Default.Menu,
                        onClick = { }
                    )
                },
                actions = {
                    CustomIconButton(
                        icon = Icons.Default.Search,
                        onClick = { }
                    )
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onClick.invoke()
            }) {
                Icon(Icons.Filled.Add, "Add") // Add icon inside FAB
            }
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(horizontal = 16.dp)
            ) {
                SelectCategoryTabView()
            }
        }
    )
}

@Composable
private fun SelectCategoryTabView() {
    val tabs = listOf(DashboardTab.Order, DashboardTab.Delayed, DashboardTab.History)
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    text = { Text(tab.title) },
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                        coroutineScope.launch {
                            listState.animateScrollToItem(0)
                        }
                    }
                )
            }
        }
        LazyColumn(
            contentPadding = PaddingValues(vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            state = listState
        ) {
            val selectedTab = tabs[selectedTabIndex]
            items(selectedTab.data) { item ->
                if (selectedTab is DashboardTab.History) {
                    HistoryItemView(item = item, onClick = { })
                } else if (selectedTab is DashboardTab.Delayed) {
                    DelayedItemView(item = item, onClick = { })
                } else {
                    OrderItemView(item = item, onClick = { })
                }
            }
        }

    }
}

@Immutable
sealed class DashboardTab(val title: String, val data: List<OrderItemModel>) {
    data object Order : DashboardTab("Pesanan", dummyValueOrder)
    data object Delayed : DashboardTab("Belum Bayar", dummyValueDelayed)
    data object History : DashboardTab("Riwayat", dummyValueHistory)
}

//@Composable
//private fun SelectCategoryTabView() {
//    var selectedTab by remember{ mutableStateOf(OrderType.Order) }
//    CustomTabRowView (
//        selectedTabIndex = selectedTab.ordinal,
//        tabWidth = 180.dp
//    ) {
//        OrderType.entries.forEach { tab ->
//            val selected = selectedTab == tab
//            CustomTabView (
//                selected = selected,
//                onClick = { selectedTab = tab }
//            ) {
//                Text(tab.title)
//            }
//        }
//    }
//}
//enum class OrderType (val title:String){
//    Order("Pesanan"),
//    Delayed("Belum Bayar"),
//    History("Riwayat")
//}

@Preview
@Composable
private fun DashboardScreenPreview() {
    DesainmuTheme {

    }
}