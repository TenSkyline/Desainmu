package com.example.desainmu.presentation.ui.dashboard.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun DashboardFloatingActionButton(onClick: () -> Unit) {
    FloatingActionButton(onClick = { onClick.invoke() }) {
        Icon(Icons.Filled.Add, "Add")
    }
}