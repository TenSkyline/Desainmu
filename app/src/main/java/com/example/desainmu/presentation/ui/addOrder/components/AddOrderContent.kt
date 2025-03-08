package com.example.desainmu.presentation.ui.addOrder.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.common.sharedComponents.CustomOutlinedTextField
import com.example.desainmu.presentation.common.sharedComponents.DatePickerFieldToModal
import com.example.desainmu.presentation.common.sharedComponents.DropdownTextField
import com.example.desainmu.presentation.ui.addOrder.AddOrderEvent
import com.example.desainmu.presentation.ui.addOrder.AddOrderState

@Composable
internal fun AddOrderContent(
    padding: PaddingValues,
    uiState: AddOrderState,
    onEvent: (AddOrderEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
    ) {
        AddOrderDesignList(
            onEvent = { onEvent.invoke(it) },
            uiState = uiState
        )
        ElevatedButton(
            onClick = {
//                onEvent.invoke(AddOrderEvent.SaveItem)
                onEvent.invoke(AddOrderEvent.ToMeasurement(design = uiState.selectedDesign)) },
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text("Berikutnya")
        }
    }
}

@Composable
private fun AddOrderDesignList(
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
                onEvent = onEvent,
                uiState = uiState
            )
        }
    }
}

@Composable
private fun AddOrderItemView(
    onEvent: (AddOrderEvent) -> Unit,
    uiState: AddOrderState
) {
    CustomOutlinedTextField(
        placeHolder = "Judul",
        value = uiState.addOrderDetails.title,
        onValueChange = { onEvent.invoke(AddOrderEvent.SetTitle(it)) }
    ) { }
    CustomOutlinedTextField(
        placeHolder = "Deskripsi",
        value = uiState.addOrderDetails.description,
        onValueChange = { onEvent.invoke(AddOrderEvent.SetDescription(it)) }
    ) { }
    DatePickerFieldToModal()
    Spacer(modifier = Modifier.height(16.dp))
    DropdownTextField(modifier = Modifier,
        label = "Pilih Desain Ukuran",
        options = Design.entries.map { it.title },
        selectedOption = uiState.selectedDesign.title,
        onOptionSelected = { title ->
            val design = Design.findByTitle(title)
            onEvent(AddOrderEvent.SetSelectedDesign(design))
        }
    )
}
