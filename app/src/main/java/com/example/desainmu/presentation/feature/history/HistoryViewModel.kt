package com.example.desainmu.presentation.feature.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desainmu.data.database.DesainmuLocalDb
import com.example.desainmu.data.database.model.ItemTable
import com.example.desainmu.presentation.feature.dashboard.components.DashboardItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel@Inject constructor(
    private val database: DesainmuLocalDb
): ViewModel() {
    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(HistoryState())

    val uiEffect get() = _uiEffect.asSharedFlow()
    private val _uiEffect = MutableSharedFlow<HistoryEffect>()

    private val itemDao = database.itemDao()

    init {
        loadItems()
    }

    fun handleEvent(event: HistoryEvent) {
        when (event) {
            HistoryEvent.NavigateUp -> emit(HistoryEffect.NavigateUp)
            is HistoryEvent.SearchItem -> _uiState.update {
                it.copy(searchQuery = event.query)
            }

            is HistoryEvent.UpdateSearchActive -> _uiState.update { it.copy(isSearchActive = event.isActive) }
        }
    }

    private fun loadItems() {
        viewModelScope.launch {
            itemDao.getItemsByIsPayed().map { itemTables ->
                itemTables.map { itemTable ->
                    itemTable.toOrderItemModel() //Transform ItemTable to OrderItemModel
                }
            }.collect { orderItemModels ->
                //Update the state flow with the new list of OrderItemModel
                _uiState.update {
                    it.copy(items = orderItemModels)
                }
            }
        }
    }

    private fun ItemTable.toOrderItemModel(): DashboardItemModel {
        return DashboardItemModel(
            id = this.id,
            title = this.title,
            description = this.description,
            dateAdded = this.dateAdded,
            selectedDate = this.selectedDate,
            daysLeft = this.daysLeft,
            isDone = this.isDone,
            dateDone = this.dateDone,
            daysOfWork = this.daysOfWork,
            isPayed = this.isPayed,
            datePayed = this.datePayed
        )
    }

    private fun emit(effect: HistoryEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}