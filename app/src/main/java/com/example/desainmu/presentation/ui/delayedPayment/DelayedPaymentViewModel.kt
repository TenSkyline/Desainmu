package com.example.desainmu.presentation.ui.delayedPayment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DelayedPaymentViewModel : ViewModel() {
    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(DelayedPaymentState())

    val uiEffect get() = _uiEffect.asSharedFlow()
    private val _uiEffect = MutableSharedFlow<DelayedPaymentEffect>()

    fun handleEvent(event: DelayedPaymentEvent) {
        when (event) {
            DelayedPaymentEvent.NavigateUp -> emit(DelayedPaymentEffect.NavigateUp)
            is DelayedPaymentEvent.SearchItem -> _uiState.update {
                it.copy(searchQuery = event.query)
            }

            is DelayedPaymentEvent.UpdateSearchActive -> _uiState.update { it.copy(isSearchActive = event.isActive) }
        }
    }

    private fun emit(effect: DelayedPaymentEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}