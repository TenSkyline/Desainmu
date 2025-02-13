package com.example.desainmu.presentation.ui.delayedPayment.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.desainmu.presentation.common.sharedComponents.CustomIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DelayedPaymentTopBar(navigateUp: () -> Unit) {
    TopAppBar(
        title = { Text("Belum Bayar") },
        navigationIcon = {
            CustomIconButton(
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                onClick = { navigateUp.invoke() }
            )
        }
    )
}