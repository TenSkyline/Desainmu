package com.example.desainmu.presentation.ui.delayedPayment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.presentation.ui.dashboard.components.DashboardFloatingActionButton
import com.example.desainmu.presentation.ui.dashboard.components.DashboardTopBar
import com.example.desainmu.presentation.ui.dashboard.components.OrderItemModel
import kotlinx.coroutines.CoroutineScope

@Composable
internal fun DelayedPaymentRoute(navigateUp: () -> Unit = {},dummyValueDelayed: List<OrderItemModel>) {
    DelayedPaymentScreen(dummyValueDelayed)
}

@Composable
internal fun DelayedPaymentScreen(dummyValueDelayed: List<OrderItemModel>) {
    DelayedPaymentScaffold(dummyValueDelayed = dummyValueDelayed)
}

@Composable
private fun DelayedPaymentScaffold(
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    scope: CoroutineScope = rememberCoroutineScope(),
    onClick: () -> Unit = {},
    dummyValueDelayed: List<OrderItemModel>
) {
    Scaffold(
        topBar = { DashboardTopBar(drawerState, scope) },
        floatingActionButton = { DashboardFloatingActionButton(onClick) },
        content = { padding ->
            DelayedPaymentContent(padding, dummyValueDelayed)
        }
    )
}

@Composable
internal fun OrderItem(item: OrderItemModel) {
    // Implement your OrderItem UI here
    Text(text = item.title)
}

@Composable
internal fun DelayedPaymentContent(padding: PaddingValues, dummyValueDelayed: List<OrderItemModel>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
    ) {
        LazyColumn {
            items(dummyValueDelayed) { item: OrderItemModel ->
                OrderItem(item = item)
            }
        }
    }
}
