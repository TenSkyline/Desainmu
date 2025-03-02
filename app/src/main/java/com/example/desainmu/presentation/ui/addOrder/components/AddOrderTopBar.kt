package com.example.desainmu.presentation.ui.addOrder.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.desainmu.presentation.common.sharedComponents.CustomIconButton
import com.example.desainmu.presentation.ui.addOrder.AddOrderEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddOrderTopBar(onEvent: (AddOrderEvent) -> Unit) {
    TopAppBar(
        title = { Text("Tambah Pesanan") },
        navigationIcon = {
            CustomIconButton(
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                onClick = { onEvent.invoke(AddOrderEvent.NavigateUp) }
            )
        }
    )
}