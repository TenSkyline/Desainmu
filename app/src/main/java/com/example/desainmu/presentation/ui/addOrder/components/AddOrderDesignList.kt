package com.example.desainmu.presentation.ui.addOrder.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.Design

@Composable
fun AddOrderDesignList(selectedDesign: Design, onSelectedDesign: (Design) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 72.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            AddOrderItemView(
                selectedDesign = selectedDesign,
                onSelectedDesign = onSelectedDesign
            )
        }
    }
}