package com.example.desainmu.presentation.addOrder.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.desainmu.ui.component.CustomOutlinedTextField
import com.example.desainmu.ui.component.DatePickerDocked
import com.example.desainmu.ui.component.DatePickerModal
import com.example.desainmu.ui.theme.DesainmuTheme

@Composable
internal fun AddOrderItemView() {
    CustomOutlinedTextField(
        placeHolder = "Judul",
        value = "",
    ) { }
    CustomOutlinedTextField(
        placeHolder = "Deskripsi",
        value = "",
    ) { }
    DatePickerDocked()
}
