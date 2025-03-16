package com.example.desainmu.presentation.feature.dashboard

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
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val database: DesainmuLocalDb
): ViewModel() {
    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(DashboardState())

    val uiEffect get() = _uiEffect.asSharedFlow()
    private val _uiEffect = MutableSharedFlow<DashboardEffect>()

    private val itemDao = database.itemDao()

    init {
        // Load the items from the database when the ViewModel is created
        // This will call loadDataForTab with index 0
        loadItems()
        loadDataForTab(0)
    }

    fun handleEvent(event: DashboardEvent) {
        when (event) {
            DashboardEvent.ToAddOrder -> emit(DashboardEffect.ToAddOrder)
            DashboardEvent.ToDelayed -> emit(DashboardEffect.ToDelayedPayment)
            DashboardEvent.ToHistory -> emit(DashboardEffect.ToHistory)

//            is DashboardEvent.SelectedTab -> _uiState.update {
//                it.copy(selectedTab = event.selectedTab)
//            }
            is DashboardEvent.SelectedTab -> {
                _uiState.update { it.copy(selectedTab = event.selectedTab) }
                loadDataForTab(event.selectedTab) // Call the function here
            }
        }
    }

    private fun loadItems() {
        viewModelScope.launch {
            itemDao.getItemsByDaysLeft().map { itemTables ->
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

    // Load data
    private fun loadDataForTab(tabIndex: Int) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            try {
                val items = when (tabIndex) {
                    0 -> itemDao.getItemsByDaysLeft().map { itemTables ->
                        itemTables.map { it.toOrderItemModel() }
                    }.first()

                    1 -> itemDao.getItemsByIsDone().map { itemTables ->
                        itemTables.map { it.toOrderItemModel() }
                    }.first()

                    2 -> itemDao.getItemsByIsPayed().map { itemTables ->
                        itemTables.map { it.toOrderItemModel() }
                    }.first()

                    else -> emptyList()
                }

                // Update UI with loaded items
                _uiState.update {
                    when (tabIndex) {
                        0 -> it.copy(dashboardOrderItems = items, isLoading = false)
                        1 -> it.copy(dashboardDelayedItems = items, isLoading = false)
                        2 -> it.copy(dashboardHistoryItems = items, isLoading = false)
                        else -> it.copy(isLoading = false)
                    }
                }
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.message, isLoading = false) }
            }
        }
    }

    //    Extention function to convert ItemTable to OrderItemModel
    private fun ItemTable.toOrderItemModel(): DashboardItemModel {
        return DashboardItemModel(
            id = this.id,
            title = this.title,
            subtitle = this.description,
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

    private fun emit(effect: DashboardEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}