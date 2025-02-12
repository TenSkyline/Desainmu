package com.example.desainmu.presentation.ui.addOrder

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AddOrderViewModel : ViewModel() {
    var selectedDesign : String by mutableStateOf("Kaos")
}