package com.example.desainmu.model

enum class Design(val title: String) {
    KaosLakiPolaDasar("Kaos Laki Pola Dasar"),
    Celana("Celana L/P Pola Dasar"),
    KemejaL("Kemeja Laki Pola Dasar"),
    KemejaP("Kemeja Perempuan Pola Dasar"),
    Rok("Rok Pola Dasar"),
    AtasanPerempuan("Atasan Perempuan Pola Dasar");

    companion object {
        fun findByTitle(title: String): Design = entries.find { it.title == title }
            ?: throw IllegalArgumentException("No enum constant with title $title")
    }
}