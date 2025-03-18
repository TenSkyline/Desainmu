package com.example.desainmu.presentation.feature.dashboard.components

data class DashboardItemModel(
    val id: Int,
    val title: String,
    val description: String,
    val dateAdded: Long,
    val selectedDate: Long,
    val daysLeft: Int,
    val isDone: Boolean,
    val dateDone: Long,
    val daysOfWork: Int,
    val isPayed: Boolean,
    val datePayed: Long,
)
