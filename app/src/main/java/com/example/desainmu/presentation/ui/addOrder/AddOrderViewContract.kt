package com.example.desainmu.presentation.ui.addOrder

import com.example.desainmu.model.Design
import java.time.LocalDate

/**
 * Represents Ui State for AddOrder.
 */

data class AddOrderState(
    val addOrderDetails: AddOrderDetails = AddOrderDetails(),
    val selectedDate: LocalDate = LocalDate.now(),
    val currentDate: LocalDate = LocalDate.now(),
    val selectedDesign: Design = Design.KaosLakiPolaDasar,
    val isEntryValid: Boolean = false
)

data class AddOrderDetails(
    val title: String = "",
    val description: String = "",
)

//fun AddOrderDetails.toItem(): Item = Item(
//    title = title,
//    description = description
//)
//
//fun Item.toAddOrderState(isEntryValid: Boolean = false): AddOrderState = AddOrderState(
//    addOrderDetails = this.toAddOrderDetails(),
//    isEntryValid = isEntryValid
//)
//
//fun Item.toAddOrderDetails(): AddOrderDetails = AddOrderDetails(
//    title = title,
//    description = description
//)

sealed class AddOrderEvent {
    data class SetTitle (val title: String) : AddOrderEvent()
    data class SetDescription (val description: String) : AddOrderEvent()
    data class SetSelectedDate(val selectedDate: LocalDate) : AddOrderEvent()
    data class SetSelectedDesign(val design: Design) : AddOrderEvent()
    data object NavigateUp: AddOrderEvent()
    data class ToMeasurement(val design: Design) : AddOrderEvent()
//    data object SaveOrder: AddOrderEvent()
}

sealed class AddOrderEffect {
    data object NavigateUp: AddOrderEffect()
    data class ToMeasurement(val design: Design) : AddOrderEffect()
//    data object SaveItem: AddOrderEffect()
}