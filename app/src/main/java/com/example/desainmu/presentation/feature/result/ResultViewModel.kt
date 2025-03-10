package com.example.desainmu.presentation.feature.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desainmu.data.database.DesainmuLocalDb
import com.example.desainmu.data.database.model.ItemTable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val database: DesainmuLocalDb
) : ViewModel() {
    private val itemDao = database.itemDao()

    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(ResultState())

    val uiEffect get() = _uiEffect.asSharedFlow()
    private val _uiEffect = MutableSharedFlow<ResultEffect>()

    fun handleEvent(event: ResultEvent) {
        when (event) {
            ResultEvent.NavigateUp -> emit(ResultEffect.NavigateUp)
            ResultEvent.SaveItem -> saveItem()
        }
    }

    private fun saveItem() = viewModelScope.launch {
        itemDao.upsertItem(_uiState.value.toItemTable())
    }

    private fun ResultState.toItemTable(): ItemTable {
        return ItemTable(
            title = this.title,
            description = this.description,
            dateAdded = this.dateAdded,
            selectedDate = this.selectedDate,
            daysLeft = this.daysLeft,
            dateDone = this.dateDone,
            isDone = this.isDone,
            datePayed = this.datePayed,
            isPayed = this.isPayed,
            selectedDesign = this.selectedDesign,
            banTangan = this.banTangan,
            jarakBustier = this.jarakBustier,
            kerungLengan = this.kerungLengan,
            lebarDada = this.lebarDada,
            lebarLengan = this.lebarLengan,
            lebarPunggung = this.lebarPunggung,
            lebarSiku = this.lebarSiku,
            lingkarBadan = this.lingkarBadan,
            lingkarBawah = this.lingkarBawah,
            lingkarBawahCelana = this.lingkarBawahCelana,
            lingkarLeher = this.lingkarLeher,
            lingkarLutut = this.lingkarLutut,
            lingkarMiatak = this.lingkarMiatak,
            lingkarPanggul1 = this.lingkarPanggul1,
            lingkarPanggul2 = this.lingkarPanggul2,
            lingkarPinggang = this.lingkarPinggang,
            pahaAtas = this.pahaAtas,
            panjangBaju = this.panjangBaju,
            panjangCelana = this.panjangCelana,
            panjangDada = this.panjangDada,
            panjangGamis = this.panjangGamis,
            panjangLengan = this.panjangLengan,
            panjangLutut = this.panjangLutut,
            panjangPunggung = this.panjangPunggung,
            panjangRok = this.panjangRok,
            panjangSeluruhBahu = this.panjangSeluruhBahu,
            panjangSiku = this.panjangSiku,
            sisiBadan = this.sisiBadan,
            tinggiBustier = this.tinggiBustier,
            tinggiDuduk = this.tinggiDuduk,
            tinggiPanggul = this.tinggiPanggul
        )
    }

    private fun emit(effect: ResultEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}
