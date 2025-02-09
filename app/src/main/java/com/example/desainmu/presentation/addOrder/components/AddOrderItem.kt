package com.example.desainmu.presentation.addOrder.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.Design
import com.example.desainmu.ui.component.CustomOutlinedTextField
import com.example.desainmu.ui.component.DatePickerDocked
import com.example.desainmu.ui.component.DropdownTextField

@Composable
internal fun AddOrderItemView(selectedDesign: Design, onSelectedDesign: (String) -> Unit) {

    CustomOutlinedTextField(
        placeHolder = "Judul",
        value = "",
    ) { }
    CustomOutlinedTextField(
        placeHolder = "Deskripsi",

        value = "",
    ) { }
    DatePickerDocked()
    Spacer(modifier = Modifier.height(16.dp))
    DropdownTextField( label = "Pilih Desain Ukuran",
        options = Design.entries.map { it.name },
        selectedOption = selectedDesign.name,
        onOptionSelected = {
            onSelectedDesign.invoke(it)
        }
    )
}


