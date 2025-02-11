package com.example.desainmu.model

enum class Design(val title: String) {
    Kaos("Kaos"),
    Celana("Celana"),
    Kemeja("Kemeja"),
    Rok("Rok"),
    AtasanPerempuan("Atasan Perempuan");

    companion object {
        fun findByTitle(title: String): Design? {
            return entries.find { it.title == title }

        }
    }
}