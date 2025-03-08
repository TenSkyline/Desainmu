package com.example.desainmu.model

class OrderModel (
    val id: Int = 0,
    val title: String,
    val description: String,
    val dateAdded: Long,
    val selectedDate: Long,
    val daysLeft: Int, //[selectedDate] - [dateAdded]
    val dateDone: Long,
    val isDone: Boolean,
    val datePayed: Long,
    val isPayed: Boolean,
    val dashboardTab: DashboardTab = DashboardTab.Order
){
}