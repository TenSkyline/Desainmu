package com.example.desainmu.presentation.ui.addOrder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddOrderViewModel : ViewModel() {
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

            is AddOrderEvent.Title -> _uiState.update {
                it.copy(title = event.title)
            }

            is AddOrderEvent.Description -> _uiState.update {
                it.copy(description = event.description)
            }

            is AddOrderEvent.DateChanged -> _uiState.update {
                it.copy(selectedDate = event.date)
            }

            is AddOrderEvent.SelectedDesign -> _uiState.update {
                it.copy(selectedDesign = event.design)
            }
        }
    }

    private fun emit(effect: AddOrderEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}