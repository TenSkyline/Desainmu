package com.example.desainmu.presentation.feature.addOrder

import com.example.desainmu.model.Design
import java.time.LocalDate

/**
 * Represents Ui State for AddOrder.
 */

data class AddOrderState(
    val addOrderDetails: AddOrderDetails = AddOrderDetails(),
    val selectedDate: Long = System.currentTimeMillis(),
    val selectedDesign: Design = Design.KaosLakiPolaDasar,
    val isEntryValid: Boolean = false
) {
    val currentDate: LocalDate
        get() = LocalDate.now()
}

data class AddOrderDetails(
    val title: String = "",
    val description: String = "",
)

sealed class AddOrderEvent {
    data class SetTitle (val title: String) : AddOrderEvent()
    data class SetDescription (val description: String) : AddOrderEvent()
    data class SetSelectedDate(val selectedDate: Long) : AddOrderEvent()
    data class SetSelectedDesign(val design: Design) : AddOrderEvent()
    data object NavigateUp: AddOrderEvent()
    data class ToMeasurement(val design: Design) : AddOrderEvent()
}

sealed class AddOrderEffect {
    data object NavigateUp: AddOrderEffect()
    data class ToMeasurement(val design: Design) : AddOrderEffect()
}