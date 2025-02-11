package com.example.desainmu.presentation.dashboard.components

data class OrderItemModel(
    val id: Int,
    val title: String,
    val subtitle: String,
    val deadline: String,
    val isChecked: Boolean,
)

val dummyValueOrder = listOf(
    OrderItemModel(
        id = 1,
        title = "Kaos Andini jwoiajojojsrogjnordngndrngndohgnhntnhnthntnhnthnhntntnhtonhtonhotnoht",
        subtitle = "Kain 1m, uang 50.000 wijojigjoehjguihrignrnrjngjrghiuhsduighrushighsiguhriugrhgirngiuhhnrtgjnkfgkkg",
        deadline = "10 agustus 2025",
        isChecked = false
    ),
    OrderItemModel(
        id = 2,
        title = "Celana Budi",
        subtitle = "Bayar ketika selesai",
        deadline = "4 Juli 2025",
        isChecked = false
    ),
    OrderItemModel(
        id = 3,
        title = "Rok Kartika",
        subtitle = "Butuh cepat selesai sebelum juli",
        deadline = "30 Juni 2025",
        isChecked = false
    ),
    OrderItemModel(
        id = 4,
        title = "Batik Anto",
        subtitle = "Bahan disediakan pembeli",
        deadline = "25 Juni 2025",
        isChecked = false
    ),
    OrderItemModel(
        id = 5,
        title = "Batik Anto",
        subtitle = "Bahan disediakan pembeli",
        deadline = "25 Juni 2025",
        isChecked = false
    )
)

val dummyValueDelayed = listOf(
    OrderItemModel(
        id = 1,
        title = "Kaos Andini ",
        subtitle = "Kain 1m, uang 50.000 wijojigjoehjguihrignrnrjngjrghiuhsduighrushighsiguhriugrhgirngiuhhnrtgjnkfgkkg",
        deadline = "10 agustus 2025",
        isChecked = true
    ),
    OrderItemModel(
        id = 2,
        title = "Celana Budi",
        subtitle = "Bayar ketika selesai",
        deadline = "4 Juli 2025",
        isChecked = false
    ),
    OrderItemModel(
        id = 3,
        title = "Rok Kartika",
        subtitle = "Butuh cepat selesai sebelum juli",
        deadline = "30 Juni 2025",
        isChecked = false
    ),
    OrderItemModel(
        id = 4,
        title = "Batik Anto",
        subtitle = "Bahan disediakan pembeli",
        deadline = "25 Juni 2025",
        isChecked = false
    ),
    OrderItemModel(
        id = 5,
        title = "Batik Anto",
        subtitle = "Bahan disediakan pembeli",
        deadline = "25 Juni 2025",
        isChecked = false
    )
)

val dummyValueHistory = listOf(
    OrderItemModel(
        id = 1,
        title = "Kaos Andini jwoiajojojsrogjnordngndrngndohgnhntnhnthntnhnthnhntntnhtonhtonhotnoht",
        subtitle = "Kain 1m, ",
        deadline = "10 agustus 2025",
        isChecked = false
    ),
    OrderItemModel(
        id = 2,
        title = "Celana Budi",
        subtitle = "Bayar ketika selesai",
        deadline = "4 Juli 2025",
        isChecked = false
    ),
    OrderItemModel(
        id = 3,
        title = "Rok Kartika",
        subtitle = "Butuh cepat selesai sebelum juli",
        deadline = "30 Juni 2025",
        isChecked = false
    ),
    OrderItemModel(
        id = 4,
        title = "Batik Anto",
        subtitle = "Bahan disediakan pembeli",
        deadline = "25 Juni 2025",
        isChecked = false
    ),
    OrderItemModel(
        id = 5,
        title = "Batik Anto",
        subtitle = "Bahan disediakan pembeli",
        deadline = "25 Juni 2025",
        isChecked = false
    )
)
