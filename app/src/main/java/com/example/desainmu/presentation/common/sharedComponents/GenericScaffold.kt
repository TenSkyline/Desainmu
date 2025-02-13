package com.example.desainmu.presentation.common.sharedComponents

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope

@Composable
fun GenericScaffold(
    title: String,
    drawerState: DrawerState,
    scope: CoroutineScope,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { },
        content = content
    )
}

