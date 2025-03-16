package com.example.desainmu.presentation.feature.result

import com.example.desainmu.model.DesignInput
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit


data class ResultState(
    val dateAdded: Long = System.currentTimeMillis(),
    val dateDone: Long = 0,
    val isDone: Boolean = false,
    val datePayed: Long = 0,
    val isPayed: Boolean = false,
    val daysOfWork: Int = 0,

    val lineAK: String = "3",
    val lineALGH: String = "4",
    val lineAE: String = "5",
    val lineAF: String = "7",
) {
    val title: String get() {
        val resultTitle = DesignInput.dataOrder.addOrderDetails.title
        return resultTitle
    }
    val description: String get() {
        val resultDescription = DesignInput.dataOrder.addOrderDetails.description
        return resultDescription
    }
    val selectedDate: Long get() {
        val resultSelectedDate = DesignInput.dataOrder.selectedDate
        return resultSelectedDate
    }
    val daysLeft: Int get() {
        val selectedDateLocal = Instant.ofEpochMilli(DesignInput.dataOrder.selectedDate)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
        val resultDaysLeft = ChronoUnit.DAYS.between(DesignInput.dataOrder.currentDate, selectedDateLocal)
        return resultDaysLeft.toInt()
    }
//    val daysOfWork: Int get() {
//        val resultDaysOfWork =
//    }

    val selectedDesign: String get() {
        val resultSelectedDesign = DesignInput.dataOrder.selectedDesign
        return resultSelectedDesign.toString()
    }

    val banTangan: Double get() {
        val resultBanTangan = DesignInput.dataDesign.banTangan.toDoubleOrNull() ?: 0.0
        return resultBanTangan
    }
    val jarakBustier: Double get() {
        val resultJarakBustier = DesignInput.dataDesign.jarakBustier.toDoubleOrNull() ?: 0.0
        return resultJarakBustier
    }
    val kerungLengan: Double get() {
        val resultKerungLengan = DesignInput.dataDesign.kerungLengan.toDoubleOrNull() ?: 0.0
        return resultKerungLengan
    }
    val lebarDada: Double get() {
        val resultLebarDada = DesignInput.dataDesign.lebarDada.toDoubleOrNull() ?: 0.0
        return resultLebarDada
    }
    val lebarLengan: Double get() {
        val resultLebarLengan = DesignInput.dataDesign.lebarLengan.toDoubleOrNull() ?: 0.0
        return resultLebarLengan
    }
    val lebarPunggung: Double get() {
        val resultLebarPunggung = DesignInput.dataDesign.lebarPunggung.toDoubleOrNull() ?: 0.0
        return resultLebarPunggung
    }
    val lebarSiku: Double get() {
        val resultLebarSiku = DesignInput.dataDesign.lebarSiku.toDoubleOrNull() ?: 0.0
        return resultLebarSiku
    }
    val lingkarBadan: Double get() {
        val resultLingkarBadan = DesignInput.dataDesign.lingkarBadan.toDoubleOrNull() ?: 0.0
        return resultLingkarBadan
    }
    val lingkarBawah: Double get() {
        val resultLingkarBawah = DesignInput.dataDesign.lingkarBawah.toDoubleOrNull() ?: 0.0
        return resultLingkarBawah
    }
    val lingkarBawahCelana: Double get() {
        val resultLingkarBawahCelana = DesignInput.dataDesign.lingkarBawahCelana.toDoubleOrNull() ?: 0.0
        return resultLingkarBawahCelana
    }
    val lingkarLeher: Double get() {
        val resultLingkarLeher = DesignInput.dataDesign.lingkarLeher.toDoubleOrNull() ?: 0.0
        return resultLingkarLeher
    }
    val lingkarLutut: Double get() {
        val resultLingkarLutut = DesignInput.dataDesign.lingkarLutut.toDoubleOrNull() ?: 0.0
        return resultLingkarLutut
    }
    val lingkarMiatak: Double get() {
        val resultLingkarMiatak = DesignInput.dataDesign.lingkarMiatak.toDoubleOrNull() ?: 0.0
        return resultLingkarMiatak
    }
    val lingkarPanggul1: Double get() {
        val resultLingkarPanggul1 = DesignInput.dataDesign.lingkarPanggul1.toDoubleOrNull() ?: 0.0
        return resultLingkarPanggul1
    }
    val lingkarPanggul2: Double get() {
        val resultLingkarPanggul2 = DesignInput.dataDesign.lingkarPanggul2.toDoubleOrNull() ?: 0.0
        return resultLingkarPanggul2
    }
    val lingkarPinggang: Double get() {
        val resultLingkarPinggang = DesignInput.dataDesign.lingkarPinggang.toDoubleOrNull() ?: 0.0
        return resultLingkarPinggang
    }
    val pahaAtas: Double get() {
        val resultPahaAtas = DesignInput.dataDesign.pahaAtas.toDoubleOrNull() ?: 0.0
        return resultPahaAtas
    }
    val panjangBaju: Double get() {
        val resultPanjangBaju = DesignInput.dataDesign.panjangBaju.toDoubleOrNull() ?: 0.0
        return resultPanjangBaju
    }
    val panjangCelana: Double get() {
        val resultPanjangCelana = DesignInput.dataDesign.panjangCelana.toDoubleOrNull() ?: 0.0
        return resultPanjangCelana
    }
    val panjangDada: Double get() {
        val resultPanjangDada = DesignInput.dataDesign.panjangDada.toDoubleOrNull() ?: 0.0
        return resultPanjangDada
    }
    val panjangGamis: Double get() {
        val resultPanjangGamis = DesignInput.dataDesign.panjangGamis.toDoubleOrNull() ?: 0.0
        return resultPanjangGamis
    }
    val panjangLengan: Double get() {
        val resultPanjangLengan = DesignInput.dataDesign.panjangLengan.toDoubleOrNull() ?: 0.0
        return resultPanjangLengan
    }
    val panjangLutut: Double get() {
        val resultPanjangLutut = DesignInput.dataDesign.panjangLutut.toDoubleOrNull() ?: 0.0
        return resultPanjangLutut
    }
    val panjangPunggung: Double get() {
        val resultPanjangPunggung = DesignInput.dataDesign.panjangPunggung.toDoubleOrNull() ?: 0.0
        return resultPanjangPunggung
    }
    val panjangRok: Double get() {
        val resultPanjangRok = DesignInput.dataDesign.panjangRok.toDoubleOrNull() ?: 0.0
        return resultPanjangRok
    }
    val panjangSeluruhBahu: Double get() {
        val resultPanjangSeluruhBahu = DesignInput.dataDesign.panjangSeluruhBahu.toDoubleOrNull() ?: 0.0
        return resultPanjangSeluruhBahu
    }
    val panjangSiku: Double get() {
        val resultPanjangSiku = DesignInput.dataDesign.panjangSiku.toDoubleOrNull() ?: 0.0
        return resultPanjangSiku
    }
    val sisiBadan: Double get() {
        val resultSisiBadan = DesignInput.dataDesign.sisiBadan.toDoubleOrNull() ?: 0.0
        return resultSisiBadan
    }
    val tinggiBustier: Double get() {
        val resultTinggiBustier = DesignInput.dataDesign.tinggiBustier.toDoubleOrNull() ?: 0.0
        return resultTinggiBustier
    }
    val tinggiDuduk: Double get() {
        val resultTinggiDuduk = DesignInput.dataDesign.tinggiDuduk.toDoubleOrNull() ?: 0.0
        return resultTinggiDuduk
    }
    val tinggiPanggul: Double get() {
        val resultTinggiPanggul = DesignInput.dataDesign.tinggiPanggul.toDoubleOrNull() ?: 0.0
        return resultTinggiPanggul
    }

    val lineABDC: Double get() {
        val resultAB = DesignInput.dataDesign.panjangBaju.toDoubleOrNull() ?: 0.0
        return resultAB
    }
    val lineAIDJ: Double get() {
        val resultAI = DesignInput.dataDesign.lingkarBadan.toDoubleOrNull() ?: 0.0
        return (resultAI / 4) - 2
    }
    val lineADIJBC: Double get() {
        val resultADIJBC = DesignInput.dataDesign.lingkarBadan.toDoubleOrNull() ?: 0.0
        return resultADIJBC / 4
    }
    val lineAG: Double get() {
        val resultAG = DesignInput.dataDesign.panjangSeluruhBahu.toDoubleOrNull() ?: 0.0
        return resultAG / 2
    }
    val lineHJ: Double get() {
        val resultHJ = DesignInput.dataDesign.lingkarBadan.toDoubleOrNull() ?: 0.0
        return resultHJ / 4
    }
}

sealed class ResultEvent {
    data object NavigateUp: ResultEvent()
    data object SaveItem: ResultEvent()
    data object NavigateToDashboard : ResultEvent()

}

sealed class ResultEffect {
    data object NavigateUp: ResultEffect()
    data object NavigateToDashboard: ResultEffect()

}