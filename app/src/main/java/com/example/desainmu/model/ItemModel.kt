package com.example.desainmu.model

data class ItemModel(
    val id: Int,
    val title: String,
    val subtitle: String,
    val dateAdded: Long,
    val selectedDate: Long,
    val daysLeft: Int,
    val isDone: Boolean,
    val dateDone: Long,
    val daysOfWork: Int,
    val isPayed: Boolean,
    val datePayed: Long,
)


//val dummyValueOrder = listOf(
//    OrderItemModel(
//        id = 1,
//        title = "Kaos Andini jwoiajojojsrogjnordngndrngndohgnhntnhnthntnhnthnhntntnhtonhtonhotnoht",
//        subtitle = "Kain 1m, uang 50.000 wijojigjoehjguihrignrnrjngjrghiuhsduighrushighsiguhriugrhgirngiuhhnrtgjnkfgkkg",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false
//    ),
//    OrderItemModel(
//        id = 2,
//        title = "Celana Budi",
//        subtitle = "Bayar ketika selesai",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false
//    ),
//    OrderItemModel(
//        id = 3,
//        title = "Rok Kartika",
//        subtitle = "Butuh cepat selesai sebelum juli",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false
//    ),
//    OrderItemModel(
//        id = 4,
//        title = "Batik Anto",
//        subtitle = "Bahan disediakan pembeli",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false
//    ),
//    OrderItemModel(
//        id = 5,
//        title = "Batik Anto",
//        subtitle = "Bahan disediakan pembeli",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false
//    )
//)
//
//val dummyValueDelayed = listOf(
//    DashboardItemModel(
//        id = 1,
//        title = "Kaos Andini ",
//        subtitle = "Kain 1m, uang 50.000 wijojigjoehjguihrignrnrjngjrghiuhsduighrushighsiguhriugrhgirngiuhhnrtgjnkfgkkg",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false,
//        dateAdded = 20157,
//        daysOfWork = 6,
//        datePayed = 20176
//    ),
//    DashboardItemModel(
//        id = 2,
//        title = "Celana Budi",
//        subtitle = "Bayar ketika selesai",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false,
//        dateAdded = 20157,
//        daysOfWork = 6,
//        datePayed = 20176
//    ),
//    DashboardItemModel(
//        id = 3,
//        title = "Rok Kartika",
//        subtitle = "Butuh cepat selesai sebelum juli",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false,
//        dateAdded = 20157,
//        daysOfWork = 6,
//        datePayed = 20176
//    ),
//    DashboardItemModel(
//        id = 4,
//        title = "Batik Anto",
//        subtitle = "Bahan disediakan pembeli",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false,
//        dateAdded = 20157,
//        daysOfWork = 6,
//        datePayed = 20176
//    ),
//    DashboardItemModel(
//        id = 5,
//        title = "Batik Anto",
//        subtitle = "Bahan disediakan pembeli",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false,
//        dateAdded = 20157,
//        daysOfWork = 6,
//        datePayed = 20176
//    )
//)
////
//val dummyValueHistory = listOf(
//    DashboardItemModel(
//        id = 1,
//        title = "Kaos Andini jwoiajojojsrogjnordngndrngndohgnhntnhnthntnhnthnhntntnhtonhtonhotnoht",
//        subtitle = "Kain 1m, ",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false,
//        dateAdded = 20157,
//        daysOfWork = 6,
//        datePayed = 20176
//    ),
//    DashboardItemModel(
//        id = 2,
//        title = "Celana Budi",
//        subtitle = "Bayar ketika selesai",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false,
//        dateAdded = 20157,
//        daysOfWork = 6,
//        datePayed = 20176
//    ),
//    DashboardItemModel(
//        id = 3,
//        title = "Rok Kartika",
//        subtitle = "Butuh cepat selesai sebelum juli",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false,
//        dateAdded = 20157,
//        daysOfWork = 6,
//        datePayed = 20176
//    ),
//    DashboardItemModel(
//        id = 4,
//        title = "Batik Anto",
//        subtitle = "Bahan disediakan pembeli",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false,
//        dateAdded = 20157,
//        daysOfWork = 6,
//        datePayed = 20176
//    ),
//    DashboardItemModel(
//        id = 5,
//        title = "Batik Anto",
//        subtitle = "Bahan disediakan pembeli",
//        selectedDate = "10 agustus 2025",
//        daysLeft = 25,
//        isDone = false,
//        dateDone = "10 agustus 2025",
//        isPayed = false,
//        dateAdded = 20157,
//        daysOfWork = 6,
//        datePayed = 20176
//    )
//)
