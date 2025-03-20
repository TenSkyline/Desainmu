package com.example.desainmu.presentation.feature.itemDetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desainmu.data.database.DesainmuLocalDb
import com.example.desainmu.data.database.model.ItemTable
import com.example.desainmu.presentation.feature.itemDetail.components.ItemDetailModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemDetailViewModel @Inject constructor(
    private val database: DesainmuLocalDb,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val itemId: Int = checkNotNull(savedStateHandle.get<String>("itemId")?.toIntOrNull()) // Fetch itemId from nav args

    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(ItemDetailState())

    val uiEffect get() = _uiEffect.asSharedFlow()
    private val _uiEffect = MutableSharedFlow<ItemDetailEffect>()

    private val itemDao = database.itemDao()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            loadData(itemId)
        }
    }

    fun handleEvent(event: ItemDetailEvent) {
        when (event) {
            ItemDetailEvent.NavigateUp -> emit(ItemDetailEffect.NavigateUp)
        }
    }

    private fun loadData(itemId: Int) {
        try {
            val item = itemDao.getItemById(itemId)  // Make sure getItems() is a suspend function!
            _uiState.value = _uiState.value.copy(item = item.toItemDetailModel())
        } catch (e: Exception) {
            _uiState.value = ItemDetailState(error = "Failed to load item: ${e.message}")
        }
    }

    private fun ItemTable.toItemDetailModel() = ItemDetailModel(
        id = this.id,
        title = title,
        description = description,
        dateAdded = dateAdded,
        selectedDate = selectedDate,
        daysLeft = daysLeft,
        isDone = isDone,
        dateDone = dateDone,
        daysOfWork = daysOfWork,
        isPayed = isPayed,
        datePayed = datePayed,
        selectedDesign = selectedDesign,
        banTangan = banTangan,
        jarakBustier = jarakBustier,
        kerungLengan = kerungLengan,
        lebarDada = lebarDada,
        lebarLengan = lebarLengan,
        lebarPunggung = lebarPunggung,
        lebarSiku = lebarSiku,
        lingkarBadan = lingkarBadan,
        lingkarBawah = lingkarBawah,
        lingkarBawahCelana = lingkarBawahCelana,
        lingkarLeher = lingkarLeher,
        lingkarLutut = lingkarLutut,
        lingkarMiatak = lingkarMiatak,
        lingkarPanggul1 = lingkarPanggul1,
        lingkarPanggul2 = lingkarPanggul2,
        lingkarPinggang = lingkarPinggang,
        pahaAtas = pahaAtas,
        panjangBaju = panjangBaju,
        panjangCelana = panjangCelana,
        panjangDada = panjangDada,
        panjangGamis = panjangGamis,
        panjangLengan = panjangLengan,
        panjangLutut = panjangLutut,
        panjangPunggung = panjangPunggung,
        panjangRok = panjangRok,
        panjangSeluruhBahu = panjangSeluruhBahu,
        panjangSiku = panjangSiku,
        sisiBadan = sisiBadan,
        tinggiBustier = tinggiBustier,
        tinggiDuduk = tinggiDuduk,
        tinggiPanggul = tinggiPanggul
    )

    private fun emit(effect: ItemDetailEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}