package com.example.desainmu.model

data class OrderParam(
    val id: Int = 0,
    val title: String,
    val description: String,
    val dateAdded: Long,
    val selectedDate: Long,
    val selectedDesign: Design
)
