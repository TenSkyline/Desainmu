package com.example.desainmu.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity data class represents a single row in the database.
 */
@Entity(tableName = "items")
data class ItemTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val dateAdded: Long, // Number of days since the epoch
    val selectedDate: Long, // Number of days since the epoch
    val daysLeft: Int, //[selectedDate] - [dateAdded]
    val dateDone: Long, // Number of days since the epoch
    val daysOfWork: Int, //[dateDone] - [selectedDate]
    val isDone: Boolean,
    val datePayed: Long, // Number of days since the epoch
    val isPayed: Boolean,
    val selectedDesign: String,
//
    val banTangan: Double? = null,
    val jarakBustier: Double? = null,
    val kerungLengan: Double? = null,
    val lebarDada: Double? = null,
    val lebarLengan: Double? = null,
    val lebarPunggung: Double? = null,
    val lebarSiku: Double? = null,
    val lingkarBadan: Double? = null,
    val lingkarBawah: Double, //not sure
    val lingkarBawahCelana: Double? = null,
    val lingkarLeher: Double? = null,
    val lingkarLutut: Double? = null,
    val lingkarMiatak: Double? = null,
    val lingkarPanggul1: Double? = null,
    val lingkarPanggul2: Double? = null,
    val lingkarPinggang: Double? = null,
    val pahaAtas: Double? = null,
    val panjangBaju: Double? = null,
    val panjangCelana: Double? = null,
    val panjangDada: Double? = null,
    val panjangGamis: Double? = null,
    val panjangLengan: Double, //not sure
    val panjangLutut: Double? = null,
    val panjangPunggung: Double? = null,
    val panjangRok: Double? = null,
    val panjangSeluruhBahu: Double? = null,
    val panjangSiku: Double? = null,
    val sisiBadan: Double? = null,
    val tinggiBustier: Double? = null,
    val tinggiDuduk: Double? = null,
    val tinggiPanggul: Double? = null

)