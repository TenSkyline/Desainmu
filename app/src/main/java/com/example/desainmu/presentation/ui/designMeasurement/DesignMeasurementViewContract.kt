package com.example.desainmu.presentation.ui.designMeasurement

data class DesignMeasurementState (
    val banTangan: String = "",
    val jarakBustier: String = "",
    val kerungLengan: String = "",
    val lebarDada: String = "",
    val lebarLenganPanjang: String = "",
    val lebarLenganPendek: String = "",
    val lebarPunggung: String = "",
    val lebarSiku: String = "",
    val lingkarBadan: String = "",
    val lingkarBawah: String = "", //not sure
    val lingkarBawahCelana: String = "",
    val lingkarLeher: String = "",
    val lingkarLutut: String = "",
    val lingkarMiatak: String = "",
    val lingkarPanggul1: String = "",
    val lingkarPanggul2: String = "",
    val lingkarPinggang: String = "",
    val pahaAtas: String = "",
    val panjangBahu: String = "",
    val panjangBaju: String = "",
    val panjangCelana: String = "",
    val panjangDada: String = "",
    val panjangGamis: String = "",
    val panjangLengan: String = "", //not sure
    val panjangLenganPanjang: String = "",
    val panjangLenganPendek: String = "",
    val panjangLutut: String = "",
    val panjangPunggung: String = "",
    val panjangRok: String = "",
    val panjangSeluruhBahu: String = "",
    val panjangSeluruhnya: String = "",
    val panjangSiku: String = "",
    val sisiBadan: String = "",
    val tinggiBustier: String = "",
    val tinggiDuduk: String = "",
    val tinggiPanggul: String = ""
)

sealed class DesignMeasurementEvent {
    data class BanTangan (val banTangan: String) : DesignMeasurementEvent()
    data class JarakBustier (val jarakBustier: String) : DesignMeasurementEvent()
    data class KerungLengan (val kerungLengan: String) : DesignMeasurementEvent()
    data class LebarDada (val lebarDada: String) : DesignMeasurementEvent()
    data class LebarLenganPanjang (val lebarLenganPanjang: String) : DesignMeasurementEvent()
    data class LebarLenganPendek (val lebarLenganPendek: String) : DesignMeasurementEvent()
    data class LebarPunggung (val lebarPunggung: String) : DesignMeasurementEvent()
    data class LebarSiku (val lebarSiku: String) : DesignMeasurementEvent()
    data class LingkarBadan (val lingkarBadan: String) : DesignMeasurementEvent()
    data class LingkarBawah (val lingkarBawah: String) : DesignMeasurementEvent()
    data class LingkarBawahCelana (val lingkarBawahCelana: String) : DesignMeasurementEvent()
    data class LingkarLeher (val lingkarLeher: String) : DesignMeasurementEvent()
    data class LingkarLutut (val lingkarLutut: String) : DesignMeasurementEvent()
    data class LingkarMiatak (val lingkarMiatak: String) : DesignMeasurementEvent()
    data class LingkarPanggul1 (val lingkarPanggul1: String) : DesignMeasurementEvent()
    data class LingkarPanggul2 (val lingkarPanggul2: String) : DesignMeasurementEvent()
    data class LingkarPinggang (val lingkarPinggang: String) : DesignMeasurementEvent()
    data class PahaAtas (val pahaAtas: String) : DesignMeasurementEvent()
    data class PanjangBahu (val panjangBahu: String) : DesignMeasurementEvent()
    data class PanjangBaju (val panjangBaju: String) : DesignMeasurementEvent()
    data class PanjangCelana (val panjangCelana: String) : DesignMeasurementEvent()
    data class PanjangDada (val panjangDada: String) : DesignMeasurementEvent()
    data class PanjangGamis (val panjangGamis: String) : DesignMeasurementEvent()
    data class PanjangLengan (val panjangLengan: String) : DesignMeasurementEvent()
    data class PanjangLenganPanjang (val panjangLenganPanjang: String) : DesignMeasurementEvent()
    data class PanjangLenganPendek (val panjangLenganPendek: String) : DesignMeasurementEvent()
    data class PanjangLutut (val panjangLutut: String) : DesignMeasurementEvent()
    data class PanjangPunggung (val panjangPunggung: String) : DesignMeasurementEvent()
    data class PanjangRok (val panjangRok: String) : DesignMeasurementEvent()
    data class PanjangSeluruhBahu (val panjangSeluruhBahu: String) : DesignMeasurementEvent()
    data class PanjangSeluruhnya (val panjangSeluruhnya: String) : DesignMeasurementEvent()
    data class PanjangSiku (val panjangSiku: String) : DesignMeasurementEvent()
    data class SisiBadan (val sisiBadan: String) : DesignMeasurementEvent()
    data class TinggiBustier (val tinggiBustier: String) : DesignMeasurementEvent()
    data class TinggiDuduk (val tinggiDuduk: String) : DesignMeasurementEvent()
    data class TinggiPanggul (val tinggiPanggul: String) : DesignMeasurementEvent()

}