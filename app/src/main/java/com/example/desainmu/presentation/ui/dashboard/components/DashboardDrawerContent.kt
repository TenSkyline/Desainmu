package com.example.desainmu.presentation.ui.dashboard.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun DashboardDrawerContent() {
    ModalDrawerSheet {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(12.dp))
            DrawerTitle()
            DrawerSection1()
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
private fun DrawerSection1() {
    Text(
        "Section 1",
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.titleMedium
    )
    NavigationDrawerItem(
        label = { Text("Item 1") },
        selected = false,
        onClick = { /* Handle click */ }
    )
    NavigationDrawerItem(
        label = { Text("Item 2") },
        selected = false,
        onClick = { /* Handle click */ }
    )
}

@Composable
private fun DrawerSection2() {
    Text(
        "Section 2",
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.titleMedium
    )
    NavigationDrawerItem(
        label = { Text("Settings") },
        selected = false,
        icon = { Icon(Icons.Outlined.Settings, contentDescription = null) },
        badge = { Text("20") }, // Placeholder
        onClick = { /* Handle click */ }
    )
}