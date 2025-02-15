package com.example.desainmu.presentation.ui.addOrder.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.desainmu.presentation.common.sharedComponents.CustomIconButton
import com.example.desainmu.presentation.ui.addOrder.AddOrderNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddOrderTopBar(navigationEvent: (AddOrderNav) -> Unit) {
    TopAppBar(
        title = { Text("Tambah Pesanan") },
        navigationIcon = {
            CustomIconButton(
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                onClick = { navigationEvent.invoke(AddOrderNav.NavigateUp) }
            )
        }
    )
}