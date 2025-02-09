package com.example.desainmu.presentation.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.desainmu.presentation.addOrder.navigation.ADD_ORDER_ROUTE
import com.example.desainmu.presentation.dashboard.components.OrderItemView
import com.example.desainmu.presentation.dashboard.components.dummyValue
import com.example.desainmu.ui.component.CustomIconButton
import com.example.desainmu.ui.component.CustomTabRowView
import com.example.desainmu.ui.component.CustomTabView
import com.example.desainmu.ui.theme.DesainmuTheme

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
                    .padding(vertical = 24.dp, horizontal = 16.dp)
            ) {
                SelectCategoryTabView()
                LazyColumn(
                    contentPadding = PaddingValues(vertical = 24.dp, horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(dummyValue, key = { it.id }) { category ->
                        OrderItemView(item = category) { }
                    }
                }
            }
        }
    )
}

@Composable
private fun SelectCategoryTabView() {
    var selectedTab by remember{ mutableStateOf<OrderType>(OrderType.Order) }
    CustomTabRowView (
        selectedTabIndex = selectedTab.ordinal,
        tabWidth = 180.dp
    ) {
        OrderType.entries.forEach { tab ->
            val selected = selectedTab == tab
            CustomTabView (
                selected = selected,
                onClick = { selectedTab = tab }
            ) {
                Text(tab.title)
            }
        }
    }
}
enum class OrderType (val title:String){
    Order("Pesanan"),
    Delayed("Belum Bayar"),
    History("Riwayat")
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    DesainmuTheme {

    }
}