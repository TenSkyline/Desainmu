package com.example.desainmu.presentation.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.desainmu.presentation.dashboard.navigation.DASHBOARD_ROUTE
import com.example.desainmu.ui.component.CustomIconButton
import com.example.desainmu.ui.component.CustomOutlinedTextField
import com.example.desainmu.ui.theme.DesainmuTheme

@Composable
internal fun DashboardRoute() {
    DashboardScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DashboardScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Dashboard")
                },
                navigationIcon = {
                    CustomIconButton(
                        icon = Icons.Default.Menu,
                        onClick = { }
                    )
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(vertical = 24.dp, horizontal = 16.dp)
            ) {

            }
        })
}

@Preview
@Composable
private fun DashboardScreenPreview() {
    DesainmuTheme {
        DashboardScreen()
    }
}