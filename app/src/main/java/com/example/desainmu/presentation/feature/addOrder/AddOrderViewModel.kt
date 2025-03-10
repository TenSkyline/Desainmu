package com.example.desainmu.presentation.feature.addOrder


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desainmu.data.database.DesainmuLocalDb
import com.example.desainmu.data.database.model.ItemTable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddOrderViewModel @Inject constructor(
    private val database: DesainmuLocalDb
): ViewModel() {

    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(AddOrderState())

    val uiEffect get() = _uiEffect.asSharedFlow()
    private val _uiEffect = MutableSharedFlow<AddOrderEffect>()

    fun handleEvent(event: AddOrderEvent) {
        when (event) {
            AddOrderEvent.NavigateUp -> emit(AddOrderEffect.NavigateUp)
            is AddOrderEvent.ToMeasurement -> emit(
                AddOrderEffect.ToMeasurement(
                    design = event.design
                )
            )

            is AddOrderEvent.SetTitle -> _uiState.update {
                AddOrderState(addOrderDetails = it.addOrderDetails.copy(title = event.title))
            }

            is AddOrderEvent.SetDescription -> _uiState.update {
                AddOrderState(addOrderDetails = it.addOrderDetails.copy(description = event.description))
            }

            is AddOrderEvent.SetSelectedDate -> _uiState.update {
                it.copy(selectedDate = event.selectedDate)
            }

            is AddOrderEvent.SetSelectedDesign -> _uiState.update {
                it.copy(selectedDesign = event.design)
            }
        }
    }

    private fun emit(effect: AddOrderEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}