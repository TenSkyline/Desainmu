package com.example.desainmu.presentation.ui.delayedPayment

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DelayedPaymentViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<DelayedPaymentState> = MutableStateFlow(DelayedPaymentState())
    val uiState: StateFlow<DelayedPaymentState> get() = _uiState.asStateFlow()

    fun handleEvent(event: DelayedPaymentEvent) {
        when (event) {
            is DelayedPaymentEvent.SearchItem -> _uiState.update { it.copy(searchQuery = event.query)
            }
            is DelayedPaymentEvent.UpdateSearchActive -> _uiState.update { it.copy(isSearchActive = event.isActive) }
        }
    }
}