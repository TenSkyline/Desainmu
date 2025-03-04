package com.example.desainmu.presentation.ui.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HistoryViewModel: ViewModel() {
    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(HistoryState())

    val uiEffect get() = _uiEffect.asSharedFlow()
    private val _uiEffect = MutableSharedFlow<HistoryEffect>()

    fun handleEvent(event: HistoryEvent) {
        when (event) {
            HistoryEvent.NavigateUp -> emit(HistoryEffect.NavigateUp)
            is HistoryEvent.SearchItem -> _uiState.update {
                it.copy(searchQuery = event.query)
            }

            is HistoryEvent.UpdateSearchActive -> _uiState.update { it.copy(isSearchActive = event.isActive) }
        }
    }

    private fun emit(effect: HistoryEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}