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

@Composable
internal fun AddOrderItemView(selectedDesign: Design, onSelectedDesign: (Design) -> Unit) {
    var judul by remember { mutableStateOf("") }
    var deskripsi by remember { mutableStateOf("") }

    CustomOutlinedTextField(
        placeHolder = "Judul",
        value = judul,
        onValueChange = {judul = it}
    ) { }
    CustomOutlinedTextField(
        placeHolder = "Deskripsi",
        value = deskripsi,
        onValueChange = {deskripsi = it}
    ) { }
    DatePickerFieldToModal()
    Spacer(modifier = Modifier.height(16.dp))
    DropdownTextField( modifier = Modifier,
        label = "Pilih Desain Ukuran",
        options = Design.entries.map { it.title },
        selectedOption = selectedDesign.title,
        onOptionSelected = {title->
            val design = Design.findByTitle(title)
            onSelectedDesign(design)
        }
    )
}


