package com.example.desainmu.presentation.ui.addOrder

data class AddOrderState (
    val title: String = "",
    val description: String = ""
)

sealed class AddOrderEvent {
    data class Title (val title: String) : AddOrderEvent()
    data class Description (val description: String) : AddOrderEvent()
}