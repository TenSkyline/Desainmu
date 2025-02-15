package com.example.desainmu.presentation.ui.addOrder.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.presentation.ui.addOrder.AddOrderEvent
import com.example.desainmu.presentation.ui.addOrder.AddOrderState

@Composable
fun AddOrderDesignList(
//    selectedDesign: Design,
//    onSelectedDesign: (Design) -> Unit,
    onEvent: (AddOrderEvent) -> Unit,
    uiState: AddOrderState
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 72.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            AddOrderItemView(
//                selectedDesign = selectedDesign,
//                onSelectedDesign = onSelectedDesign,
                onEvent = onEvent,
                uiState = uiState
            )
        }
    }
}