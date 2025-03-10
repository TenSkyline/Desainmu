package com.example.desainmu.presentation.feature.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desainmu.data.database.DesainmuLocalDb
import com.example.desainmu.data.database.model.ItemTable
import com.example.desainmu.model.DashboardTab
import com.example.desainmu.presentation.feature.addOrder.AddOrderState
import com.example.desainmu.presentation.feature.dashboard.components.OrderItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
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

//    private val _items = MutableStateFlow<List<OrderItemModel>>(emptyList())
//    val items: StateFlow<List<OrderItemModel>> = _items.asStateFlow()
//
//    private val itemDao = database.itemDao()
//
//    init {
//        // Load the items from the database when the ViewModel is created
//        loadCategories()
//    }

    fun handleEvent(event: DashboardEvent) {
        when (event) {
            DashboardEvent.ToAddOrder -> emit(DashboardEffect.ToAddOrder)
            DashboardEvent.ToDelayed -> emit(DashboardEffect.ToDelayedPayment)
            DashboardEvent.ToHistory -> emit(DashboardEffect.ToHistory)

            is DashboardEvent.SelectedTab -> _uiState.update {
                it.copy(selectedTab = event.selectedTab)
            }
        }
    }

//    private fun loadItems() {
//        viewModelScope.launch {
//            itemDao.getItemsByDaysLeft().map { itemTables ->
//                itemTables.map { itemTable ->
//                    itemTable.toOrderItemModel() // Assuming you have this function
//                }
//            }.collect { orderItemModels ->
//                //Update the state flow with the new list of OrderItemModel
//                _items.value = orderItemModels
//            }
//        }
//    }

//    //Extention function to convert ItemTable to OrderItemModel
//    private fun ItemTable.toOrderItemModel(): OrderItemModel {
//        return OrderItemModel(
//            id = this.id,
//            title = this.title,
//            subtitle = this.description,
//            selectedDate = this.selectedDate.toString(),
//            dateDone = this.dateDone.toString(),
//            daysLeft = this.daysLeft,
//            isDone = this.isDone,
//            isPayed = this.isPayed,
//        )
//    }
//
//    private fun loadCategories() {
//        viewModelScope.launch {
//            // Assuming you have a method to get categories from the database
//            val categoriesFromDb: List<ItemTable> = itemDao.getItemsByDaysLeft()
//            _uiState.update {
//                it.copy(categories = categoriesFromDb)
//            }
//        }
//    }

    private fun emit(effect: DashboardEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}