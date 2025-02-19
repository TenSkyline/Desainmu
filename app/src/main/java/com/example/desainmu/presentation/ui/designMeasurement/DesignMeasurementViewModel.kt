package com.example.desainmu.presentation.ui.designMeasurement

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DesignMeasurementViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<DesignMeasurementState> = MutableStateFlow(
        DesignMeasurementState()
    )
    val uiState: StateFlow<DesignMeasurementState> get() = _uiState.asStateFlow()

    fun handleEvent(event: DesignMeasurementEvent) {
        when (event) {
            is DesignMeasurementEvent.BanTangan -> _uiState.update {
                it.copy(banTangan = event.banTangan)
            }
            is DesignMeasurementEvent.KerungLengan -> _uiState.update {
                it.copy(kerungLengan = event.kerungLengan)
            }
            is DesignMeasurementEvent.LebarDada -> _uiState.update {
                it.copy(lebarDada = event.lebarDada)
            }
            is DesignMeasurementEvent.LebarLenganPanjang -> _uiState.update {
                it.copy(lebarLenganPanjang = event.lebarLenganPanjang)
            }
            is DesignMeasurementEvent.LebarLenganPendek -> _uiState.update {
                it.copy(lebarLenganPendek = event.lebarLenganPendek)
            }
            is DesignMeasurementEvent.LebarPunggung -> _uiState.update {
                it.copy(lebarPunggung = event.lebarPunggung)
            }
            is DesignMeasurementEvent.LebarSiku -> _uiState.update {
                it.copy(lebarSiku = event.lebarSiku)
            }
            is DesignMeasurementEvent.LingkarBadan -> _uiState.update {
                it.copy(lingkarBadan = event.lingkarBadan)
            }
            is DesignMeasurementEvent.LingkarBawahCelana -> _uiState.update {
                it.copy(lingkarBawahCelana = event.lingkarBawahCelana)
            }
            is DesignMeasurementEvent.LingkarLeher -> _uiState.update {
                it.copy(lingkarLeher = event.lingkarLeher)
            }
            is DesignMeasurementEvent.LingkarLutut -> _uiState.update {
                it.copy(lingkarLutut = event.lingkarLutut)
            }
            is DesignMeasurementEvent.LingkarMiatak -> _uiState.update {
                it.copy(lingkarMiatak = event.lingkarMiatak)
            }
            is DesignMeasurementEvent.LingkarPanggul1 -> _uiState.update {
                it.copy(lingkarPanggul1 = event.lingkarPanggul1)
            }
            is DesignMeasurementEvent.LingkarPanggul2 -> _uiState.update {
                it.copy(lingkarPanggul2 = event.lingkarPanggul2)
            }
            is DesignMeasurementEvent.LingkarPinggang -> _uiState.update {
                it.copy(lingkarPinggang = event.lingkarPinggang)
            }
            is DesignMeasurementEvent.PahaAtas -> _uiState.update {
                it.copy(pahaAtas = event.pahaAtas)
            }
            is DesignMeasurementEvent.PanjangBahu -> _uiState.update {
                it.copy(panjangBahu = event.panjangBahu)
            }
            is DesignMeasurementEvent.PanjangBaju -> _uiState.update {
                it.copy(panjangBaju = event.panjangBaju)
            }
            is DesignMeasurementEvent.PanjangCelana -> _uiState.update {
                it.copy(panjangCelana = event.panjangCelana)
            }
            is DesignMeasurementEvent.PanjangDada -> _uiState.update {
                it.copy(panjangDada = event.panjangDada)
            }
            is DesignMeasurementEvent.PanjangLenganPanjang -> _uiState.update {
                it.copy(panjangLenganPanjang = event.panjangLenganPanjang)
            }
            is DesignMeasurementEvent.PanjangLenganPendek -> _uiState.update {
                it.copy(panjangLenganPendek = event.panjangLenganPendek)
            }
            is DesignMeasurementEvent.PanjangLutut -> _uiState.update {
                it.copy(panjangLutut = event.panjangLutut)
            }
            is DesignMeasurementEvent.PanjangPunggung -> _uiState.update {
                it.copy(panjangPunggung = event.panjangPunggung)
            }
            is DesignMeasurementEvent.PanjangRok -> _uiState.update {
                it.copy(panjangRok = event.panjangRok)
            }
            is DesignMeasurementEvent.PanjangSeluruhBahu -> _uiState.update {
                it.copy(panjangSeluruhBahu = event.panjangSeluruhBahu)
            }
            is DesignMeasurementEvent.PanjangSeluruhnya -> _uiState.update {
                it.copy(panjangSeluruhnya = event.panjangSeluruhnya)
            }
            is DesignMeasurementEvent.PanjangSiku -> _uiState.update {
                it.copy(panjangSiku = event.panjangSiku)
            }
            is DesignMeasurementEvent.TinggiDuduk -> _uiState.update {
                it.copy(tinggiDuduk = event.tinggiDuduk)
            }
            is DesignMeasurementEvent.TinggiPanggul -> _uiState.update {
                it.copy(tinggiPanggul = event.tinggiPanggul)
            }
        }
    }
}