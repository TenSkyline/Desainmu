package com.example.desainmu.presentation.ui.dashboard.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun DashboardDrawerContent(onClick: () -> Unit, scope: CoroutineScope, drawerState: DrawerState) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val drawerWidth = screenWidth * 0.8f
    ModalDrawerSheet(
        modifier = Modifier.widthIn(max = drawerWidth)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(12.dp))
            DrawerTitle()
            DrawerSection1(onClick, scope, drawerState)
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            DrawerSection2()
        }
    }
}

@Composable
private fun DrawerTitle() {
    Text(
        "Menu",
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.titleLarge
    )
    HorizontalDivider()
}

@Composable
private fun DrawerSection1(onClick: () -> Unit, scope: CoroutineScope, drawerState: DrawerState) {
    NavigationDrawerItem(
        label = { Text("Belum Bayar") },
        icon = { Icon(Icons.Filled.Warning, contentDescription = "Belum Bayar") },
        selected = false,
        onClick = {
            scope.launch { drawerState.close() }
            onClick.invoke()
        }
    )
    NavigationDrawerItem(
        label = { Text("Riwayat") },
        icon = { Icon(Icons.Filled.Done, contentDescription = "Riwayat") },
        selected = false,
        onClick = { /* Handle click */ }
    )
}

@Composable
private fun DrawerSection2() {
    NavigationDrawerItem(
        label = { Text("Galeri") },
        icon = { Icon(Icons.Filled.Star, contentDescription = "Galeri") },
        selected = false,
        onClick = { /* Handle click */ }
    )
    NavigationDrawerItem(
        label = { Text("Disukai") },
        icon = { Icon(Icons.Filled.Favorite, contentDescription = "Disukai") },
        selected = false,
        onClick = { /* Handle click */ }
    )
//    NavigationDrawerItem(
//        label = { Text("Settings") },
//        selected = false,
//        icon = { Icon(Icons.Outlined.Settings, contentDescription = null) },
//        badge = { Text("20") }, // Placeholder
//        onClick = { /* Handle click */ }
//    )
}