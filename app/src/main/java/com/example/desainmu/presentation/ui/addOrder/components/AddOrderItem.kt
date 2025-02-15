package com.example.desainmu.presentation.ui.addOrder.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.common.sharedComponents.CustomOutlinedTextField
import com.example.desainmu.presentation.common.sharedComponents.DatePickerFieldToModal
import com.example.desainmu.presentation.common.sharedComponents.DropdownTextField
import com.example.desainmu.presentation.ui.addOrder.AddOrderEvent
import com.example.desainmu.presentation.ui.addOrder.AddOrderState
import com.example.desainmu.presentation.ui.history.HistoryEvent

@Composable
internal fun AddOrderItemView(
    selectedDesign: Design,
    onSelectedDesign: (Design) -> Unit,
    onEvent: (AddOrderEvent) -> Unit,
    uiState: AddOrderState
) {
    CustomOutlinedTextField(
        placeHolder = "Judul",
        value = uiState.title,
        onValueChange = { onEvent.invoke(AddOrderEvent.Title(it)) }
    ) { }
    CustomOutlinedTextField(
        placeHolder = "Deskripsi",
        value = uiState.description,
        onValueChange = { onEvent.invoke(AddOrderEvent.Description(it)) }
    ) { }
    DatePickerFieldToModal()
    Spacer(modifier = Modifier.height(16.dp))
    DropdownTextField(modifier = Modifier,
        label = "Pilih Desain Ukuran",
        options = Design.entries.map { it.title },
        selectedOption = selectedDesign.title,
        onOptionSelected = { title ->
            val design = Design.findByTitle(title)
            onSelectedDesign(design)
        }
    )
}


