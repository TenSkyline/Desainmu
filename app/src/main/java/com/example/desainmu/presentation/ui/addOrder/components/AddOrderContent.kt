package com.example.desainmu.presentation.ui.addOrder.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.presentation.ui.addOrder.AddOrderNav
import com.example.desainmu.presentation.ui.addOrder.AddOrderState

@Composable
fun AddOrderContent(
    padding: PaddingValues,
    navigationEvent: (AddOrderNav) -> Unit,
    uiState: AddOrderState,
//    onClickDesign: (Design) -> Unit,
//    onEvent: (AddOrderEvent) -> Unit,
//    uiState: AddOrderState
) {
//    val selectedDesign by remember { mutableStateOf(Design.Kaos) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
    ) {
        AddOrderDesignList(
//            selectedDesign = selectedDesign,
//            onSelectedDesign = { selectedDesign = it },
//            onEvent = onEvent,
            onEvent = { navigationEvent.invoke(AddOrderNav.OnEvent(it)) },
            uiState = uiState
        )
        ElevatedButton(
//            onClick = { onClickDesign.invoke(selectedDesign) },
            onClick = { navigationEvent.invoke(AddOrderNav.ToMeasurement(uiState.selectedDesign)) },
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text("Berikutnya")
        }
    }
}