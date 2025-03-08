package com.example.desainmu.presentation.common.sharedViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desainmu.data.database.ItemDao
import com.example.desainmu.model.SortType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class OrderViewModel(
    private val dao: ItemDao
): ViewModel() {
    private val _sortType = MutableStateFlow(SortType.TITLE_NAME)

    @OptIn(ExperimentalCoroutinesApi::class)
    private val _orders = _sortType
        .flatMapLatest { sortType ->
            when(sortType){
                SortType.TITLE_NAME -> dao.getItemsByTitle()
//                SortType.DAYS_LEFT -> dao.getItemsByDaysLeft()
//                SortType.DATE_ADDED -> dao.getItemsBySelectedDate()
                SortType.DAYS_LEFT -> TODO()
                SortType.IS_DONE -> TODO()
                SortType.IS_PAYED -> TODO()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _uiState = MutableStateFlow(OrderState())
    val uiState = combine(_uiState, _sortType, _orders) { uiState, sortType, orders ->
        uiState.copy(
            orders = orders,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), OrderState())

    fun handleEvent(event: OrderEvent){
        when(event){
            is OrderEvent.DeleteOrder -> {
                viewModelScope.launch {
                    dao.delete(event.order)
                }
            }

            is OrderEvent.SortOrder -> {
                _sortType.value = event.sortType
            }
        }
    }
}