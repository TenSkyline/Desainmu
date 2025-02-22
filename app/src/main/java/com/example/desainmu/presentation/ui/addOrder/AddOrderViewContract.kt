package com.example.desainmu.presentation.ui.addOrder

import com.example.desainmu.model.Design
import java.time.LocalDate

data class AddOrderState (
    val title: String = "",
    val description: String = "",
    val selectedDesign: Design = Design.KaosLakiPolaDasar,
    val selectedDate: LocalDate = LocalDate.now()
)

sealed class AddOrderEvent {
    data class Title (val title: String) : AddOrderEvent()
    data class Description (val description: String) : AddOrderEvent()
    data class SelectedDesign(val design: Design) : AddOrderEvent()
    data class DateChanged(val date: LocalDate) : AddOrderEvent()
}