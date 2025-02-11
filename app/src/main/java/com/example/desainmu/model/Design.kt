package com.example.desainmu.model

enum class Design(val title: String) {
    Kaos("Kaos L/P Pola Dasar"),
    Celana("Celana L/P Pola Dasar"),
    Kemeja("Kemeja L/P Pola Dasar"),
    Rok("Rok Pola Dasar"),
    AtasanPerempuan("Atasan Perempuan Pola Dasar");

    companion object {
        fun findByTitle(title: String): Design = entries.find { it.title == title }
            ?: throw IllegalArgumentException("No enum constant with title $title")
    }
}