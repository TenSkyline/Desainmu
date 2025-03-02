package com.example.desainmu.presentation.ui.addOrder

import com.example.desainmu.model.Design
import java.time.LocalDate

/**
 * Represents Ui State for AddOrder.
 */
data class AddOrderState (
    val title: String = "",
    val description: String = "",
    val selectedDate: LocalDate = LocalDate.now(),
    val selectedDesign: Design = Design.KaosLakiPolaDasar,
    val isEntryValid: Boolean = false
)

sealed class AddOrderEvent {
    data class Title (val title: String) : AddOrderEvent()
    data class Description (val description: String) : AddOrderEvent()
    data class DateChanged(val date: LocalDate) : AddOrderEvent()
    data class SelectedDesign(val design: Design) : AddOrderEvent()
    data object NavigateUp: AddOrderEvent()
    data class ToMeasurement(val design: Design) : AddOrderEvent()
}

sealed class AddOrderEffect {
    data object NavigateUp: AddOrderEffect()
    data class ToMeasurement(val design: Design) : AddOrderEffect()
}