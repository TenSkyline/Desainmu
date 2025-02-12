package com.example.desainmu.presentation.ui.dashboard.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.desainmu.presentation.common.sharedComponents.CustomIconButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardTopBar(
    drawerState: DrawerState,
    scope: CoroutineScope
) {
    TopAppBar(
        title = { Text("Halaman Utama") },
        navigationIcon = {
            CustomIconButton(
                icon = Icons.Default.Menu,
                onClick = {
                    scope.launch {
                        if (drawerState.isClosed) {
                            drawerState.open()
                        } else {
                            drawerState.close()
                        }
                    }
                }
            )
        },
        actions = {
            CustomIconButton(
                icon = Icons.Default.Search,
                onClick = { }
            )
        }
    )
}
