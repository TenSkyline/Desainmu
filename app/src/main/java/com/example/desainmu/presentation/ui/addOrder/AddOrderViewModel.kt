package com.example.desainmu.presentation.ui.addOrder

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class AddOrderViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<AddOrderState> = MutableStateFlow(
        AddOrderState()
    )
    val uiState: StateFlow<AddOrderState> get() = _uiState.asStateFlow()

    fun handleEvent(event: AddOrderEvent) {
        when (event) {
            is AddOrderEvent.Title -> _uiState.update {
                it.copy(title = event.title)
            }
            is AddOrderEvent.Description -> _uiState.update {
                it.copy(description = event.description)
            }
            is AddOrderEvent.SelectedDesign -> _uiState.update {
                it.copy(selectedDesign = event.design)
            }
            is AddOrderEvent.DateChanged -> _uiState.update {
                it.copy(selectedDate = event.date)
            }
        }
    }
}