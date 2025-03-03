package com.example.desainmu.presentation.ui.designMeasurement

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DesignMeasurementViewModel : ViewModel() {
    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(DesignMeasurementState())

    val uiEffect get() = _uiEffect.asSharedFlow()
    private val _uiEffect = MutableSharedFlow<DesignMeasurementEffect>()

    fun handleEvent(event: DesignMeasurementEvent) {
        when (event) {
            DesignMeasurementEvent.NavigateUp -> emit(DesignMeasurementEffect.NavigateUp)
            is DesignMeasurementEvent.ToResult -> emit(
                DesignMeasurementEffect.ToResult(
                    design = event.design
                )
            )

            is DesignMeasurementEvent.BanTangan -> _uiState.update {
                it.copy(banTangan = event.banTangan)
            }

            is DesignMeasurementEvent.JarakBustier -> _uiState.update {
                it.copy(jarakBustier = event.jarakBustier)
            }

            is DesignMeasurementEvent.KerungLengan -> _uiState.update {
                it.copy(kerungLengan = event.kerungLengan)
            }

            is DesignMeasurementEvent.LebarDada -> _uiState.update {
                it.copy(lebarDada = event.lebarDada)
            }

            is DesignMeasurementEvent.LebarLengan -> _uiState.update {
                it.copy(lebarLengan = event.lebarLengan)
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

            is DesignMeasurementEvent.LingkarBawah -> _uiState.update {
                it.copy(lingkarBawah = event.lingkarBawah)
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

            is DesignMeasurementEvent.PanjangBaju -> _uiState.update {
                it.copy(panjangBaju = event.panjangBaju)
            }

            is DesignMeasurementEvent.PanjangCelana -> _uiState.update {
                it.copy(panjangCelana = event.panjangCelana)
            }

            is DesignMeasurementEvent.PanjangDada -> _uiState.update {
                it.copy(panjangDada = event.panjangDada)
            }

            is DesignMeasurementEvent.PanjangGamis -> _uiState.update {
                it.copy(panjangGamis = event.panjangGamis)
            }

            is DesignMeasurementEvent.PanjangLengan -> _uiState.update {
                it.copy(panjangLengan = event.panjangLengan)
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

            is DesignMeasurementEvent.PanjangSiku -> _uiState.update {
                it.copy(panjangSiku = event.panjangSiku)
            }

            is DesignMeasurementEvent.SisiBadan -> _uiState.update {
                it.copy(sisiBadan = event.sisiBadan)
            }

            is DesignMeasurementEvent.TinggiBustier -> _uiState.update {
                it.copy(tinggiBustier = event.tinggiBustier)
            }

            is DesignMeasurementEvent.TinggiDuduk -> _uiState.update {
                it.copy(tinggiDuduk = event.tinggiDuduk)
            }

            is DesignMeasurementEvent.TinggiPanggul -> _uiState.update {
                it.copy(tinggiPanggul = event.tinggiPanggul)
            }
        }
    }

    private fun emit(effect: DesignMeasurementEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}