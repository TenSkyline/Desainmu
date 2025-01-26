package com.example.desainmu.presentation.addOrder.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.ui.component.CustomOutlinedTextField
import com.example.desainmu.ui.component.DatePickerDocked
import com.example.desainmu.ui.component.DropdownTextField

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun AddOrderItemView() {
    var selectedDesign by remember { mutableStateOf("Kaos") }
    val design = listOf("Kaos", "Celana", "Kemeja", "Rok")
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
        options = design,
        selectedOption = selectedDesign,
        onOptionSelected = { selectedDesign = it })
}
